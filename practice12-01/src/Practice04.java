import javax.swing.*;
import java.awt.*;
class ShakeFrame extends Thread{
private Component component;
private int dir;
    public ShakeFrame(Component component) {
        this.component = component;
    }

    @Override
    public void run() {
        while(true){
//            int nowX = component.getX(); // 위치한 현재 x값
//            int nowY = component.getY(); // 위치한 현재 y갑
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);

            component.setLocation(300+x,300+y);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Practice04 extends JFrame {
    public Practice04() throws HeadlessException {
        this.setTitle("Clock");
        this.setSize(500, 500);

        this.setLocation(100,100);

        ShakeFrame shakeFrame = new ShakeFrame(this);
        shakeFrame.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice04();
    }
}
