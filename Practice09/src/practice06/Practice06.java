package practice06;

import javax.swing.*;
import java.awt.*;

public class Practice06 extends JFrame {
    public Practice06() throws HeadlessException {
        this.setTitle("Click random");
        this.setSize(500,500);
        Container c = this.getContentPane();
        c.setLayout(null);
        JLabel label = new JLabel("C");
        label.setLocation(100,100);
        label.setSize(50,50);
        c.add(label);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Practice06();
    }
}
