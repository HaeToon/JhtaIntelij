import javax.swing.*;
import java.awt.*;


public class Practice0501 extends JFrame implements Runnable {
    public Practice0501() throws HeadlessException {
        this.setTitle("Clock");
        this.setSize(500, 500);

        this.setLocation(100,100);
        Thread thread = new Thread(this);
        thread.start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0501();
    }

    @Override
    public void run() {
        int x = this.getX();
        int y = this.getY();
        int dir =0;
        int gap = 2;
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dir = Math.random()<0.5 ? 1 : -1;
            x+=dir*gap;
            dir = Math.random()<0.5 ? 1 : -1;
            y+=dir*gap;
            this.setLocation(x,y);
        }
    }
}
