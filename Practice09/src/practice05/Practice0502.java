package practice05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;


public class Practice0502 extends JFrame {
   private JLabel label = new JLabel("Love Java");
    int num = 10;

    public Practice0502() throws HeadlessException {
        this.setTitle("Training05 JLabel");
        this.setSize(500, 500);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(label);
        InnerClass innerClass = new InnerClass();
        c.addKeyListener(innerClass);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);

    }

    class InnerClass implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyChar());
            if (e.getKeyChar() == '+') {
                num += 5;
            } else if (num > 5 && e.getKeyChar() == '-') {
                num -= 5;
            }
            label.setFont(new Font("Arial", Font.PLAIN, num));
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public static void main(String[] args) {
        new Practice0502();
    }
}
