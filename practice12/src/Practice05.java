import javax.swing.*;
import java.awt.*;

class Shakit extends Thread {
    private JLabel label;

    public Shakit(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        while (true) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            label.setLocation(100 + x, 100 + y);

        }
    }
}

public class Practice05 extends JFrame {
    JLabel label = new JLabel();
    public Practice05() throws HeadlessException {
        this.setTitle("진동하는 레이블 만들기");
        this.setSize(300, 300);

        Container c = this.getContentPane();

        Shakit shakit = new Shakit(label);
        shakit.start();
        c.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice05();
    }
}
