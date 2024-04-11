import javax.swing.*;
import java.awt.*;

class ShakeLabel0502 extends Thread {
    private Component component;
    private int dir=0;
    private int gap = 2;
    public ShakeLabel0502(Component component) {
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

public class Practice0502 extends JFrame {
    public Practice0502() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(500,500);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ShakeLabel0502 shakeLabel0502 = new ShakeLabel0502(this);
        shakeLabel0502.start();
    }

    public static void main(String[] args) {
        new Practice0502();
    }
}
