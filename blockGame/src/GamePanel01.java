import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class GamePanel01 extends JPanel implements Runnable {
    //거리측정하는방법 피타고라스 정리
    static final int GAME_WIDTH = 1200;
    static final int GAME_HIGHT = 800;
    private Ball ball;
    private Paddle paddle;
    private BlockGame blockGame;
    private Color arr[] = {Color.red, Color.blue, Color.orange, Color.pink, Color.magenta, Color.green, Color.yellow, Color.cyan};
    private BlockGame blocks[];
    private ImageIcon imageIcon = new ImageIcon("image/heart2.png");
    private Image image = imageIcon.getImage();
    Thread thread;
    private int life =3;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("맑은 고딕",Font.BOLD,24));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티알리아싱 으로 좀더 부드럽게 처리
        g.setColor(Color.white);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        for(int i=0; i<life; i++){
            g.drawImage(image,20+(60*i),15,this);
        }
        for (int i = 0; i < 40; i++) {
            g.setColor(arr[i % arr.length]);
            for (int j = 0; j < 119; j++) {
                g.fillRect(5 + (j * 10), 60 + (i * 10), 9, 9);
            }
        }
    }
    public GamePanel01() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HIGHT)); //사이즈 정확하게 정하는것setPreferredSize(new Dimension(width,height))
        this.setBackground(Color.black);
        ball = new Ball(GAME_WIDTH/2-5, 740, 10);
//        ball = new Ball(0, 0, 10);
        paddle = new Paddle(550, 750, 100, 20);
        blockGame = new BlockGame(70,70,90,90);
        thread = new Thread(this);
        thread.start();
        ball.setSpeedX(2);
        ball.setSpeedY(-2);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {//누르고있는동안
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.setLeft(true);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.setRight(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.setSpeedX(0);
                    paddle.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.setSpeedX(0);
                    paddle.setRight(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    System.out.println("SPACE");
                    thread = new Thread(GamePanel01.this);
                    thread.start();
                    if(life==0){
                        life=3;
                    }
                }
            }
        });
    }

    private void moveBall() {
        //이동을 메서드로 만들수있음.
//        ball.setX(ball.getX() + ball.getSpeedX()); //x축이동
        ball.moveX(ball.getSpeedX()); //ball 클래스에 moveLeft 메서드를 만들어서 조금더 간단하게 만듬.
//        ball.setY(ball.getY() + ball.getSpeedY()); //y축이동
        ball.moveY(ball.getSpeedY());//ball 클래스에 moveRight 메서드를 만들어서 조금더 간단하게 만듬.

        if (ball.isRightTouched()) { //x축 튕기기
            ball.setSpeedX(-2);
        } else if (ball.isLeftTouched()) {
            ball.setSpeedX(2);
        }

        if (ball.getY() >= GAME_HIGHT + 50 - ball.getRadius()) { //y축 바닥 닿을시
            thread.interrupt();
            ball.setX(paddle.getX()+paddle.getWidth()/2-ball.getRadius()/2);
            ball.setY(paddle.getY()-ball.getRadius());
            life--;

        } else if (ball.getY() <= 460) {
            ball.setSpeedY(2);
        }
        if (
                hitObject(new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                        new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight()))) {
            System.out.println("충돌");
            ball.setSpeedY(-2);
        }


    }

    private void movePaddle() {
        paddle.setX(paddle.getX() + paddle.getSpeedX());
        if (paddle.isLeft()) {
            paddle.setSpeedX(-10);
        }
        if (paddle.isRight()) {
            paddle.setSpeedX(10);
        }
        if (paddle.getX() >= GAME_WIDTH - paddle.getWidth()) {
            System.out.println("오른쪽끝");
            paddle.setX(GAME_WIDTH - paddle.getWidth()-1);
        }
        if (paddle.getX() <= 0) {
            System.out.println("왼쪽끝");
            paddle.setX(1);
        }

    }

    @Override
    public void run() {
        System.out.println(ball.getX());
        System.out.println(ball.getY());
        while (true) {
            moveBall();
            movePaddle();
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                return;
            }
        }
    }

    //Rectangle 은 x,y,width,height가 있어야함.
    private boolean hitObject(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02); //rect01과 rect02가 겹친다면 true 리턴
    }
}
