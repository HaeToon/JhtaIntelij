import javax.swing.*;
import java.awt.*;

class FlickingLabel extends JLabel implements Runnable {
    private int delay;

    public FlickingLabel(String str, int delay) {
        this.delay = delay;
        this.setText(str);
        this.setBackground(Color.orange);
        this.setOpaque(true);
        Thread thread = new Thread(this); //FlickingLabel이 Runnable을 implement하므로 this가능.
        thread.start();
    }

    @Override
    public void run() {
        boolean isFlick = false;
        while (true) {
            //여기에 움직일것들
            isFlick = !isFlick;
            if (isFlick == true) {
                this.setBackground(Color.green);
            } else {
                this.setBackground(Color.orange);
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Quiz02 extends JFrame {
    public Quiz02() throws HeadlessException {
        this.setTitle("깜빡이");
        this.setSize(200, 200);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new FlickingLabel("Hello", 500));
        c.add(new FlickingLabel("World", 1000));


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Quiz02();
    }
}
