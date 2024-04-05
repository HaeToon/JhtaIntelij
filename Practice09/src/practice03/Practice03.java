package practice03;

import javax.swing.*;
import java.awt.*;

public class Practice03 extends JFrame {
    public Practice03() throws HeadlessException {
        this.setTitle("Left키로 문자열 교체");
        this.setSize(600,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel("Love Jave");
        c.add(label);
        MyKeyListener myKeyListener = new MyKeyListener();
        label.addKeyListener(myKeyListener);
          c.addKeyListener(myKeyListener);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        label.setFocusable(true);
        c.requestFocus();
        label.requestFocus();
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
