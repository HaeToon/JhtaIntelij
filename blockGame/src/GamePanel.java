import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {
    private Color arr[] = {Color.red, Color.blue, Color.orange, Color.pink, Color.magenta, Color.green, Color.yellow, Color.cyan};
    private ImageIcon imageIcon = new ImageIcon("image/heart2.png");
    private Image image = imageIcon.getImage();
    static final int GAME_WIDTH = 1200;
    static final int GAME_HIGHT = 800;
    private Ball ball;
    private Paddle paddle;

    Thread thread;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티알리아싱 으로 좀더 부드럽게 처리
        g.setColor(Color.white);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        for(int i=0; i<ball.getLife(); i++){
            g.drawImage(image,20+(60*i),15,this);
        }
        for (int i = 0; i < 40; i++) {
            g.setColor(arr[i % arr.length]);
            for (int j = 0; j < 119; j++) {
                g.fillRect(5 + (j * 10), 60 + (i * 10), 9, 9);
            }
        }
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HIGHT)); //사이즈 정확하게 정하는것setPreferredSize(new Dimension(width,height))
        this.setBackground(Color.black);
        ball = new Ball(0, 0, 20);
        paddle = new Paddle(600, GAME_HIGHT-50, 100, 20);
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
            }
        });
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
        int posX = ball.getX();
        int posY = ball.getY();
        int sideX = 2;
        int sideY = 2;
        System.out.println(ball.getX());
        while (true) {
            movePaddle();
            ball.setX(posX);
            ball.setY(posY);
            posX += sideX;
            if (posX >= GAME_WIDTH - ball.getRadius()) {
                sideX *= -1;
            } else if (posX <= 0) {
                sideX *= -1;
            }
            posY += sideY;
            if (posY >= GAME_HIGHT - ball.getRadius()) {
                sideY *= -1;
            } else if (posY <= 0) {
                sideY *= -1;
            }
            if(posX>=paddle.getX() && posX+ball.getRadius()<=paddle.getX()+paddle.getWidth() && posY ==paddle.getY()-paddle.getHeight()){
                System.out.println("닿았다.");
                sideY *= -1;
            }
//            System.out.println(ball.getX());
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
