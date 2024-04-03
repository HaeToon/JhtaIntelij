package practice01;

import javax.swing.*;
import java.awt.*;

public class Practice0102 extends JFrame {
    public Practice0102() throws HeadlessException {
        this.setTitle("Training JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel("label");
        MyMouseListener01 mouseListener = new MyMouseListener01();
        label.addMouseListener(mouseListener);
        c.add(label);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Practice0102();
    }
}
