package practice05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Practice0504 extends JFrame {
    int num = 10;

    public Practice0504() throws HeadlessException {
        this.setTitle("Training05 JLabel");
        this.setSize(500, 500);
        Container c = this.getContentPane();
        JLabel label = new JLabel("Love Java");
        c.setLayout(new FlowLayout());
        c.add(label);
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') {
                    num += 5;
                } else if (num > 5 && e.getKeyChar() == '-') {
                    num -= 5;
                }
                label.setFont(new Font("Arial", Font.PLAIN, num));
            }
        };
        c.addKeyListener(keyListener);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);

    }

    public static void main(String[] args) {
        new Practice0504();
    }
}
