package practice05;

import javax.swing.*;
import java.awt.*;

public class Practice05 extends JFrame {
    int num=10;
    public Practice05() throws HeadlessException {
        this.setTitle("Training05 JLabel");
        this.setSize(500,500);
        Container c = this.getContentPane();
        JLabel label = new JLabel("Love Java");

        label.setFont(new Font("Arial",Font.PLAIN,num));


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
