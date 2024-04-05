import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PaddlePanel extends JPanel implements Runnable {
    //implement Runnable == thread void run 을 생성해야함.
    //process (program 하나 ex)테트리스 ) thread (노예)
    // thread는 하나의 프로그램(process)안에서 여러개의 동시다발적 일을 할수있음.(빠르게 처리해서 동시에 하는것으로 보이지만 동시에 하는건 아니다.)
    private int posX=0;
    private int posY=0;
    public String isDirection="0";
    private int num;
    private Thread thread;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(50+posX,200+posY,20,20);
    }

    public PaddlePanel() {
        thread = new Thread(this);
        thread.start();
        this.setFocusable(true);
        this.requestFocus();

    }

    public void moveXY(String isDeraction){
        if(isDeraction.equals("right"))posX+=2;
        if(isDeraction.equals("left"))posX-=2;
        if(isDeraction.equals("up"))posY-=2;
        if(isDeraction.equals("down"))posY+=2;
        repaint();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10); //0.1초동안 잠시 대기시킴
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //일해야할것들 여기다가 넣어주기
            moveXY(isDirection);

            System.out.println(++num);
        }
    }
}
public class Paddle extends JFrame {
    PaddlePanel paddlePanel = new PaddlePanel();
    public Paddle() throws HeadlessException {
        this.setTitle("그림그리기");
        this.setSize(300,300);
        this.setContentPane(paddlePanel);

        paddlePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    paddlePanel.isDirection = "right";
//                    paddlePanel.moveXY("right");
                }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    paddlePanel.isDirection="left";
//                    paddlePanel.moveXY("left");
                } else if(e.getKeyCode()==KeyEvent.VK_UP){
                    paddlePanel.isDirection="up";
//                    paddlePanel.moveXY("up");
                }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    paddlePanel.isDirection="down";
//                    paddlePanel.moveXY("down");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Paddle();
    }

}
