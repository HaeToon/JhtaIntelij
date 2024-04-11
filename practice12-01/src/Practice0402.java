import javax.swing.*;
import java.awt.*;

class ShakeFrame0402 extends Thread {
    private Component component;
    private int dir=0;
    private int gap = 2;
    public ShakeFrame0402(Component component) {
        this.component = component;
    }

    @Override
    public void run() {
        int x = component.getX();
        int y = component.getY();

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dir = Math.random()<0.5 ? 1 : -1;
            x+=dir*gap;
            dir = Math.random()<0.5 ? 1 : -1;
            y+=dir*gap;
            component.setLocation(x,y);
        }
    }
}

public class Practice0402 extends JFrame {
    public Practice0402() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(500,500);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ShakeFrame shakeFrame = new ShakeFrame(this);
        shakeFrame.start();
    }

    public static void main(String[] args) {
        new Practice0402();
    }
}
