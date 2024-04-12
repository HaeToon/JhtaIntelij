import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel02 extends JPanel implements Runnable {
    //거리측정하는방법 피타고라스 정리
    static final int GAME_WIDTH = 1200;
    static final int GAME_HIGHT = 800;
    private Ball01 ball01;
    private Paddle paddle;
    private ImageIcon imageIcon = new ImageIcon("image/heart2.png");
    private Image image = imageIcon.getImage();
    Thread thread;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("맑은 고딕",Font.BOLD,24));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티알리아싱 으로 좀더 부드럽게 처리
        g.setColor(Color.white);
        g.fillOval(ball01.getX(), ball01.getY(), ball01.getRadius(), ball01.getRadius());
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        for(int i=0; i<ball01.getLife(); i++){
            g.drawImage(image,20+(60*i),15,this);
        }
    }
    public GamePanel02() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HIGHT)); //사이즈 정확하게 정하는것setPreferredSize(new Dimension(width,height))
        this.setBackground(Color.black);
        ball01 = new Ball01(0, 0, 10);
        paddle = new Paddle(600, 750, 100, 20);
        thread = new Thread(this);
        thread.start();
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
                    thread = new Thread(GamePanel02.this);
                    thread.start();
                }
            }
        });
    }

    private void moveBall() {
        ball01.setX(ball01.getX() + ball01.getSpeedX()); //x축이동
        ball01.setY(ball01.getY() + ball01.getSpeedY()); //y축이동

        if (ball01.getX() >= GAME_WIDTH - ball01.getRadius()) { //x축 튕기기
            ball01.setSpeedX(-2);
        } else if (ball01.getX() <= 0) {
            ball01.setSpeedX(2);
        }

        if (ball01.getY() >= GAME_HIGHT + 50 - ball01.getRadius()) { //y축 바닥 닿을시
            thread.interrupt();
            ball01.setX(paddle.getX()+paddle.getWidth()/2-ball01.getRadius()/2);
            ball01.setY(paddle.getY()-ball01.getRadius());

        } else if (ball01.getY() <= 0) {
            ball01.setSpeedY(2);
        }
        if (
                hitObject(new Rectangle(ball01.getX(), ball01.getY(), ball01.getRadius(), ball01.getRadius()),
                        new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight()))) {
            System.out.println("충돌");
            ball01.setSpeedY(-2);
        }

//        System.out.println(ball.getX());
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
            paddle.setX(GAME_WIDTH - paddle.getWidth());
        }
        if (paddle.getX() <= 0) {
            System.out.println("왼쪽끝");
            paddle.setX(0);
        }

    }

    @Override
    public void run() {
        System.out.println(ball01.getX());
        System.out.println(ball01.getY());
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
