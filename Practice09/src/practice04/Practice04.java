package practice04;

import javax.swing.*;
import java.awt.*;

public class Practice04 extends JFrame {
    public Practice04() throws HeadlessException {
        this.setTitle("Training04 JLabel");
        this.setSize(400,300);
        Container c = this.getContentPane();
        JLabel label = new JLabel("Love Java");
        c.add(label);
        MyKeyListener myKeyListener = new MyKeyListener();
        c.addKeyListener(myKeyListener);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
