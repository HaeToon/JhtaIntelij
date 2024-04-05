package practice01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Practice01 extends JFrame {
    JLabel label = new JLabel("label");
    public Practice01() throws HeadlessException {
        this.setTitle("Training JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();

        label.setSize(20,20);
        c.setLayout(new FlowLayout());
        c.add(label);
        MyMouseListener01 myMouseListener01 = new MyMouseListener01();
        label.addMouseListener(myMouseListener01);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}
