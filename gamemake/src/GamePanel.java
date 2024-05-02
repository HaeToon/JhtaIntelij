import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
public class GamePanel extends JPanel implements Runnable {
   private boolean isLoading = true;
    private boolean isStart = false;
    private boolean isEnd = false;
    private int speed = 3;
    private int monstersN=15;
    private int playTime;
    private boolean isLeft, isRight, isUp, isDown;
    static final int GAME_WIDTH = 888;
    static final int GAME_HEIGHT = 777;
    Player player = new Player(new ImageIcon("images/happy.png"), GAME_WIDTH / 2, GAME_HEIGHT / 2);
    private ImageIcon imageIcon = new ImageIcon("image/heart.png");
    private ImageIcon endIcon = new ImageIcon("Images/end.jpg");
    private Image image = imageIcon.getImage();
    private Image endImage = endIcon.getImage();
    Timer gameTimer = new Timer();
    TimerTask gameTimerTask = new TimerTask() {
        @Override
        public void run() {
            if (player.getLife()!=0)
            playTime += 1;

        }
    };
    Thread thread;

    String monsterList[] = {"images/m1.png", "images/m2.png", "images/m3.png", "images/m4.png", "images/m5.png", "images/m6.png", "images/m7.png", "images/m8.png", "images/m9.png", "images/m10.png"};
    List<Monster> monsters = new ArrayList<>();

    public GamePanel() {
        makeMonster();
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT)); //사이즈 정확하게 정하는것setPreferredSize(new Dimension(width,height))
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {//누르고있는동안
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setLeft(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setRight(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setUp(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setDown(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("엔터");
                    isLoading = false;
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setLeft(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setRight(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setUp(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setDown(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("SPACE");
                    if (!isStart) {
                        gameTimer.schedule(gameTimerTask,1000,1000);
                        for (int i = 0; i < monstersN; i++) {
                            monsters.get(i).setSpeedX((int) (Math.random() * speed+1 ));
                            monsters.get(i).setSpeedY(-(int) (Math.random() * speed+1 ));
                        }
                        thread = new Thread(GamePanel.this);
                        thread.start();
                        isStart = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(isEnd){
                        monstersN=15;
                        playTime=0;
                        isEnd=false;
                        isStart=true;
                        player.setLife(3);
                        player.setX(GAME_WIDTH/2);
                        player.setY(GAME_HEIGHT/2);
                        for(int i=0; i<monstersN; i++){
                            monsters.get(i).setX( (int) (Math.random() * GAME_WIDTH));
                            if(i<monstersN/2) {
                                monsters.get(i).setY((int) (Math.random() * GAME_HEIGHT / 4));
                            }else {
                                monsters.get(i).setY((int) (Math.random() * GAME_HEIGHT / 4) + 600);
                            }
                        }
                    }
                }
            }
        });
    }
    private void drawLoading(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        g.setColor(Color.white);
        String title = "Runaway";
        Font font = new Font("맑은고딕", Font.BOLD, 48);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int centerX = (GAME_WIDTH - fontMetrics.stringWidth(title)) / 2;
        g.setFont(new Font("맑은고딕", Font.BOLD, 48));
        g.drawString(title, centerX, 200);
        String guide01 = "Press Enter GameStart";
        String guide02 = "Avoid Monsters!";
        String guide03 = "Press Space Player Start";
        int guideX = (GAME_WIDTH - fontMetrics.stringWidth(guide01)) / 2;
        g.drawString(guide01, guideX, GAME_HEIGHT / 2);
        g.drawString(guide02, guideX + 70, GAME_HEIGHT / 2 + 100);
        g.drawString(guide03, guideX, GAME_HEIGHT / 2 + 200);
    }
    private void drawEnd(Graphics g) {
        g.drawImage(endImage,0,0,null);
        g.setColor(Color.white);
        g.drawString("몬스터를",GAME_WIDTH/4,200);
        g.drawString("피하지",GAME_WIDTH/4,300);
        g.drawString("못했습니다.",GAME_WIDTH/4,400);
        g.drawString("버틴시간 : "+playTime,GAME_WIDTH/4,500);
        g.drawString("재시작 : Enter",GAME_WIDTH/6,600);


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티알리아싱 으로 좀더 부드럽게 처리
        player.draw(g);
        g.setFont(new Font("맑은 고딕", Font.BOLD, 100));
        g.drawString("PlayTime : "+playTime,GAME_WIDTH/5,GAME_HEIGHT/2);
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).draw(g);
        }
        if (isLoading) {
            drawLoading(g);
        }
        if(isEnd){
            drawEnd(g);
        }
    }
    private void makeMonster() {
        for (int i = 0; i < monstersN; i++) {
            if (i < monstersN/2) {
                Monster monster = new Monster(new ImageIcon(monsterList[i%10]), (int) (Math.random() * GAME_WIDTH), (int) (Math.random() * GAME_HEIGHT / 4));
                monsters.add(monster);
                monsters.get(i).setSpeedY((int) (Math.random()  ));
            } else {
                Monster monster = new Monster(new ImageIcon(monsterList[i%10]), (int) (Math.random() * GAME_WIDTH), (int) (Math.random() * GAME_HEIGHT / 4) + 600);
                monsters.add(monster);
                monsters.get(i).setSpeedY(-(int) (Math.random() ));
            }
        }
        repaint();
    }
    private void moveMonster() {
        for (int i = 0; i < monstersN; i++) {
            monsters.get(i).moveX(monsters.get(i).getSpeedX());
            monsters.get(i).moveY(monsters.get(i).getSpeedY());
            if (monsters.get(i).isRightTouched()) { //x축 튕기기
                monsters.get(i).setX(GAME_WIDTH - monsters.get(i).getWidth());
                monsters.get(i).setSpeedX(-monsters.get(i).getSpeedX());
            } else if (monsters.get(i).isLeftTouched()) {
                monsters.get(i).setX(0);
                monsters.get(i).setSpeedX(-monsters.get(i).getSpeedX());
            }
            if (monsters.get(i).getY() >= GAME_HEIGHT) { //y축 바닥 닿을시
                monsters.get(i).setY(GAME_HEIGHT - monsters.get(i).getHeight());
                monsters.get(i).setSpeedY(-monsters.get(i).getSpeedY());
            } else if (monsters.get(i).getY() <= 0) { //꼭대기에 닿았을때
                monsters.get(i).setY(0);
                monsters.get(i).setSpeedY(-monsters.get(i).getSpeedY());
            }
        }
            Rectangle rectangle01 = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        for(int i=0; i<monstersN; i++){
            Rectangle rectangle02 = new Rectangle(monsters.get(i).getX(), monsters.get(i).getY(), monsters.get(i).getWidth(), monsters.get(i).getHeight());
            if(hitObject(rectangle01,rectangle02)){
                monsters.get(i).setX((int)(Math.random()*GAME_WIDTH));
                monsters.get(i).setY((int)(Math.random()*GAME_HEIGHT));
                player.setLife(player.getLife()-1);
            }
        }
    }


    private void playerMove() {
        player.moveX(player.getSpeedX());
        player.moveY(player.getSpeedY());
    }

    private void keyProcess() {
        if (isLeft()) {
            player.moveX(-4);
        }
        if (isRight()) {
            player.moveX(4);
        }
        if (isUp()) {
            player.moveY(-4);
        }
        if (isDown()) {
            player.moveY(4);
        }
    }


    @Override
    public void run() {
        while (true) {
            if(player.getLife()!=0) {
                moveMonster();
                keyProcess();
                playerMove();
            }else {
                isEnd=true;
            }
                repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                return;
            }
        }
    }
    private boolean hitObject(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02); //rect01과 rect02가 겹친다면 true 리턴
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
}