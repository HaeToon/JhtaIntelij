import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

enum GameState { //enum = 상수들의 집합체
    LOADING, END, PLAY
}

public class GamePanel extends JPanel implements Runnable {
    public static int GAME_WITDH = 1280;
    public static int GAME_HEIGHT = 800;
    private int posX = GAME_WITDH / 2;
    private int posY = GAME_HEIGHT / 2 + GAME_HEIGHT / 4;
    private boolean isLeft, isRight, isUp, isDown, isShoot;
    private boolean isBossState = false;
    private int life = 3;
    private int bombNum = 0;
    private int point = 0;
    private int count = 0;
    private int itemNum = 0;
    private int boss = 0;
    private GameState gameState = GameState.LOADING;
    Thread thread = null;

    Timer timer = new Timer(); //thread구현한것
    Timer clearTimer = new Timer(); //thread구현한것

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
//            System.out.println("타이머 테스트");
            makeEnemy();
        }
    };
    Timer giftTimer = new Timer();
    TimerTask giftTimerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("선물생성");
            makeGift();
        }
    };


    Player player = new Player(new ImageIcon("images/player.png"), GAME_WITDH / 2, GAME_HEIGHT / 2 + GAME_HEIGHT / 4);
    private BossMonster bossMonster = new BossMonster(new ImageIcon("images/boss2.png"));
    Item item = null;
    GameOver gameOver = new GameOver();
    GiftBox giftBox = null;
    ImageIcon backGround = new ImageIcon("images/bg.jpg");
    ImageIcon loadingBg = new ImageIcon("images/loadingBg.jpg");
    ImageIcon lifeImageIcon = new ImageIcon("images/life.png");
    ImageIcon ufoIcon = new ImageIcon("images/ufo.png");
    ImageIcon bombIcon = new ImageIcon("images/bomb.png");
    ImageIcon bossMonsterIcon = new ImageIcon("images/boss1.png");
    Image bombImage = bombIcon.getImage();
    Image ufoImage = ufoIcon.getImage();
    Image lifeImage = lifeImageIcon.getImage();
    String enemyList[] = {"images/m1.png", "images/m2.png", "images/m3.png", "images/m4.png", "images/m5.png"};
    String bossList[] = {"images/boss1"};

    List<Bullet> bulletList = new ArrayList<>();
    List<Enemy> enemies = new ArrayList<>(); //2초마다 한마리씩 만들어보기
    List<Boom> boomList = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();
    List<Bomb> bombList = new ArrayList<>();
    List<GiftBox> giftList = new ArrayList<>();
    List<BossBullet> bossBulletList = new ArrayList<>();

    //Bullet bullet01 = new Bullet(new ImageIcon("images/myBullet.png"),player.getX(),player.getY()-100);
    //Bullet bullet02 = new Bullet(new ImageIcon("images/myBullet.png"),player.getX(),player.getY()-50);
    public GamePanel() {
        thread = new Thread(this);
        thread.start();

        this.setPreferredSize(new Dimension(GAME_WITDH, GAME_HEIGHT)); // Panel의 크기를 정확하게 지정
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocus();
        //bulletList.add(bullet01);
        // bulletList.add(bullet02);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    posX-=10;
//                    player.setX(player.getX()-10);
//                    player.moveX(-10);
//                    player.setSpeedX(-6);
                    setLeft(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    posX+=10;
//                    player.setX(player.getX()+10);
//                player.moveX(10);
//                    player.setSpeedX(6);
                    setRight(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    posY-=10;
//                    player.setY(player.getY()-10);
//                    player.moveY(-10);
//                    player.setSpeedY(-6);
                    setUp(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    posY+=10;
//                    player.setY(player.getY()+10);
//                    player.moveY(10);
//                    player.setSpeedY(6);
                    setDown(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setShoot(false);
                }
//                player.setX(posX);
//                player.setY(posY);
//                    repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                setLeft(false);
//                setRight(false);
//                setUp(false);
//                setDown(false);
//                setShoot(false);
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    player.setSpeedX(0);
                    setLeft(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    player.setSpeedX(0);
                    setRight(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    player.setSpeedY(0);
                    setUp(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    player.setSpeedY(0);
                    setDown(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setShoot(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (gameState == GameState.LOADING) {
                        gameState = GameState.PLAY;
                        timer.schedule(timerTask, 1000, 1000); ///1초에 1번 실행
                        giftTimer.schedule(giftTimerTask, 10000, 10000);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    if (gameState == GameState.END) {
                        System.out.println("r누름");
                        timer = new Timer(); //thread구현한것

                        timerTask = new TimerTask() {
                            @Override
                            public void run() {
//            System.out.println("타이머 테스트");
                                makeEnemy();
                            }
                        };
                        giftTimer = new Timer();
                        giftTimerTask = new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("선물생성");
                                makeGift();
                            }
                        };
                        timer.schedule(timerTask, 1000, 1000); ///1초에 1번 실행
                        giftTimer.schedule(giftTimerTask, 10000, 10000);
                        life = 3;
                        itemNum = 0;
                        point = 0;
                        bombNum = 0;
                        player.setX(GAME_WITDH / 2);
                        player.setY(GAME_HEIGHT / 2 + GAME_HEIGHT / 4);
                        Thread thread = new Thread(GamePanel.this);
                        gameState = GameState.PLAY;
                        thread.start();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_B) {
                    enemies.removeAll(enemies);
                    bombNum--;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //화면 부드럽게 만들기 안티알리아싱
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //화면 부드럽게 만들기 안티알리아싱
//        if(!isStart) {
        if (gameState == GameState.LOADING) {
            g.drawImage(loadingBg.getImage(), 0, 0, null);
            g.setFont(new Font("맑은 고딕", Font.PLAIN, 72));
//            g.setColor(new Color(122, 255, 122));
            g.setColor(Color.white);
            g.drawString("Catch Monsters", GAME_WITDH / 2 - 250, GAME_HEIGHT / 6);
            g.drawImage(ufoIcon.getImage(), GAME_WITDH / 2 - ufoImage.getWidth(null) / 2, GAME_HEIGHT / 2 - ufoImage.getHeight(null) / 2, null);
//            g.setColor(new Color(122, 255, 122));
            g.drawString("Start?  Press -Enter-", GAME_WITDH / 2 - 300, GAME_HEIGHT / 2 + GAME_HEIGHT / 3 + 70);
        }
        if (gameState == GameState.PLAY) {

            g.setColor(Color.white);

            g.drawImage(backGround.getImage(), 0, 0, this);

            player.draw(g);

            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                enemy.draw(g);
            }
            for (int i = 0; i < bulletList.size(); i++) {
                Bullet bullet = bulletList.get(i);
                //  g.drawImage(bullet.getImageIcon().getImage(),bullet.getX(),bullet.getY(),null); //bullet클래스에 메서드로 만듬
                bullet.draw(g);
            }
            for (int i = 0; i < boomList.size(); i++) {
                Boom boom = boomList.get(i);
                boom.draw(g);
            }
            for (int i = 0; i < life; i++) {
                g.drawImage(lifeImage, 20 + (40 * i), 20, this);
            }
            for (int i = 0; i < bombNum; i++) {
                g.drawImage(bombImage, 20 + (60 * i), 80, this);
            }
            for (int i = 0; i < itemList.size(); i++) {
                Item item = itemList.get(i);
                item.draw(g);
            }
            for (int i = 0; i < bombList.size(); i++) {
                Bomb bomb = bombList.get(i);
                bomb.draw(g);
            }

            for (int i = 0; i < giftList.size(); i++) {
                GiftBox giftBox = giftList.get(i);
                giftBox.draw(g);

            }

            if (life == 0) {
                gameState = GameState.END;
                g.setColor(Color.black);
                g.fillRect(0, 0, GAME_WITDH, GAME_HEIGHT);
                gameOver.draw(g);
                g.setFont(new Font("맑은 고딕", Font.BOLD, 100));
                g.setColor(Color.white);
                g.drawString("Contienue?  Press -R-", GAME_WITDH / 2 - 500, GAME_HEIGHT / 2 + GAME_HEIGHT / 3 + 70);
                timer.cancel();
                giftTimer.cancel();
            }
            if (isBossState) {
                bossMonster.draw(g);
                timer.cancel();

                for (int i = 0; i < bossBulletList.size(); i++) {
                    BossBullet bossBullet = bossBulletList.get(i);
                    bossBullet.draw(g);
                }
            }
            g.setColor(Color.white);
            g.setFont(new Font("맑은 고딕", Font.BOLD, 30));
            g.drawString("point : " + point, 1100, 50);
        } else if (gameState == GameState.END) {
            g.setColor(Color.black);
            g.fillRect(0, 0, GAME_WITDH, GAME_HEIGHT);
            g.setFont(new Font("맑은 고딕", Font.BOLD, 100));
            g.setColor(Color.white);
            g.drawString("Contienue?  Press -R-", GAME_WITDH / 2 - 500, GAME_HEIGHT / 2 + GAME_HEIGHT / 3 + 70);

        }
    }

    private void makeEnemy() {
        int randomEnemy = (int) (Math.random() * enemyList.length);
        Enemy enemy = new Enemy(new ImageIcon(enemyList[randomEnemy]), (int) (Math.random() * (GAME_WITDH - 100) + 50), -30, 3);
        enemies.add(enemy);
    }


    private void makeGift() {
        GiftBox giftBox = new GiftBox(new ImageIcon("images/giftbox.png"), (int) (Math.random() * GAME_WITDH + 1), -30);
        giftList.add(giftBox);
    }

    private void makeBomb() {
        Bomb bomb = new Bomb(new ImageIcon("images/bomb.png"), (int) (Math.random() * GAME_WITDH + 1), -30);
        bombList.add(bomb);
    }

    private void checkHeart() {
        if (life <= 0) {
            //게임끝
            gameState = GameState.END;
        }
    }

    private void playerMove() {
        player.moveX(player.getSpeedX());
        player.moveY(player.getSpeedY());
        Rectangle rectangle01 = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            Rectangle rectangle02 = new Rectangle(item.getX(), item.getY(), item.getWidth(), item.getHeight());
            if (hit0bject(rectangle01, rectangle02)) {
                System.out.println("아이템 습득");
                itemNum++;
                itemList.remove(item);
            }

        }
        for (int i = 0; i < bombList.size(); i++) {
            Bomb bomb = bombList.get(i);
            Rectangle rectangle02 = new Rectangle(bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
            if (hit0bject(rectangle01, rectangle02)) {
                System.out.println("폭탄 습득");
                if (bombNum >= 2) {
                    bombNum = 2;
                } else {
                    bombNum++;
                }
                bombList.remove(bomb);
            }
        }
    }

    private void bossMove() {
        //이동을 메서드로 만들수있음.
        bossMonster.move();
    }

    private void makeBossBullet() {
        if (Math.random() < 0.01) {
            for (int i = 0; i < 12; i++) {
                BossBullet bossBullet = new BossBullet(
                        new ImageIcon("images/enomyBullet.png"),
                        bossMonster.getX() + bossMonster.getWidth() / 2 - 8,
                        bossMonster.getY() + bossMonster.getHeight());
                bossBullet.setAngle(i * 15 - 90);
                bossBulletList.add(bossBullet);
            }
        }
    }

    private void bossBulletMove() {
        for (int i = 0; i < bossBulletList.size(); i++) {
            BossBullet bossBullet = bossBulletList.get(i);
            bossBullet.move(3, bossBullet.getAngle());
            if (bossBullet.getY() <= -30) {
                bossBulletList.remove(bossBullet);
                System.out.println("총알사라짐");
            }
        }
    }

    private void giftBoxMove() {
        for (int i = 0; i < giftList.size(); i++) {
            GiftBox giftBox = giftList.get(i);
            giftBox.setY(giftBox.getY() + (int) (Math.random() * 2) + 1);
            Rectangle rectangle01 = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            Rectangle rectangle02 = new Rectangle(giftBox.getX(), giftBox.getY(), giftBox.getWidth(), giftBox.getHeight());
            if (hit0bject(rectangle01, rectangle02)) {
                System.out.println("상자 습득");
                life++;
                giftList.remove(giftBox);
            }
            if (giftBox.getY() >= GAME_HEIGHT + 50) {
                giftList.remove(giftBox);
                System.out.println("박스");
                if (life == 0) {
                    giftList.removeAll(giftList);
                }
            }
        }
    }

    private void bulletMove() {
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            bullet.setY(bullet.getY() - 10);
                Rectangle rectangle01 = new Rectangle(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
            Rectangle rectangle03 = new Rectangle(bossMonster.getX(), bossMonster.getY(), bossMonster.getWidth(), bossMonster.getHeight());
            if (hit0bject(rectangle01, rectangle03)) {
                bulletList.remove(bullet);
                bossMonster.setLife(bossMonster.getLife() - 1);
                repaint();
                if (bossMonster.getLife() <= 0) {
                    isBossState=false;
                    point+=1000;
                }
            }
            for (int j = 0; j < enemies.size(); j++) {
                Enemy enemy = enemies.get(j);
                Rectangle rectangle02 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                if (hit0bject(rectangle01, rectangle02)) {
                    bulletList.remove(bullet);
                    enemy.setLife(enemy.getLife() - 1);
                    repaint();
                    if (enemy.getLife() <= 0) {
                        enemies.remove(enemy);
                        point++;
                        count++;
                        if (count >= 10) {
                            isBossState = true;
                            count = 0;
                        }
                        Boom boom = new Boom(new ImageIcon("images/bam.png"), enemy.getX(), enemy.getY());
                        boomList.add(boom);
                        TimerTask boomTimerTask = new TimerTask() {
                            @Override
                            public void run() {
                                boomList.remove(boom);
                            }
                        };
                        clearTimer.schedule(boomTimerTask, 3000, 1000);
                        if (Math.random() < 0.1) {
                            System.out.println("아이템 생성");
                            Item item = new Item(new ImageIcon("images/star.png"), enemy.getX(), enemy.getY());
                            itemList.add(item);
                        }
                        if (Math.random() < 0.1) {
                            System.out.println("폭탄 생성");
                            Bomb bomb = new Bomb(new ImageIcon("images/bomb.png"), enemy.getX(), enemy.getY());
                            bombList.add(bomb);
                        }
                    }
                }
            }
            if (bullet.getY() <= -30) {
                bulletList.remove(bullet);
                System.out.println("총알사라짐");
            }
        }
    }

    private void enemyMove() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.setY(enemy.getY() + (int) (Math.random() * 2) + 1);
            if (enemy.getY() >= GAME_HEIGHT + 50) {
                enemies.remove(enemy);
                System.out.println("몬스터 사라짐");
                life--;
                if (life == 0) {
                    enemies.removeAll(enemies);
                }
            }
        }
    }


    private void keyProcess() { //key입력을 실시간으로 바꾸기위함.
        if (isLeft()) {
            player.moveX(-7);
            if (player.getX() <= 0) {
                player.setX(0);
                System.out.println("왼쪽 끝 닿음");
            }
        }
        if (isRight) {
            player.moveX(7);
            if (player.getX() >= GAME_WITDH - 32) {
                player.setX(GAME_WITDH - 32);
                System.out.println("오른쪽 끝 닿음");
            }
        }
        if (isUp) {
            player.moveY(-7);
            if (player.getY() <= 0) {
                player.setY(0);
                System.out.println("위쪽 끝 닿음");
            }
        }
        if (isDown) {
            player.moveY(7);
            if (player.getY() >= GAME_HEIGHT - 32) {
                player.setY(GAME_HEIGHT - 32);
                System.out.println("아래쪽 끝 닿음");
            }
        }
        player.moveX(player.getSpeedX());
        player.moveY(player.getSpeedY());
        if (isShoot) {
            int bulletX = 0;
            for (int i = 0; i <= itemNum; i++) {
                if (i == 0) {
                    bulletX = 12;
                } else if (i == 1) {
                    bulletX = 26;
                } else if (i == 2) {
                    bulletX = -4;
                } else {
                    itemNum = 2;
                    life++;
                    System.out.println("아이템최대로 life증가");
                }
                Bullet bullet = new Bullet(new ImageIcon("images/myBullet.png"), player.getX() + bulletX, player.getY() - 30);
                bulletList.add(bullet);
                setShoot(false);
            }


        }
    }

    @Override
    public void run() {
        while (true) {
            //실행코드 넣기
            keyProcess();
            playerMove();
            bulletMove();


            giftBoxMove();
            if (isBossState) {
                bossMove();
                makeBossBullet();
                bossBulletMove();
            } else {
                enemyMove();
            }
            repaint();
            if (life == 0) {
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
    }

    private boolean hit0bject(Rectangle rect01, Rectangle rect02) {

        return rect01.intersects(rect02);
    }
}
