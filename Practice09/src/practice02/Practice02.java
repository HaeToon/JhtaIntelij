package practice02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class Practice02 extends JFrame {
    public Practice02() throws HeadlessException {
        this.setTitle("Training02 JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.green);
        JLabel label = new JLabel("label");
        c.add(label);
        MyMouseListener02 myMouseListener02 = new MyMouseListener02();
        c.addMouseListener(myMouseListener02);
        c.addMouseMotionListener(myMouseListener02);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
