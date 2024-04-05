import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice06 extends JFrame {
    public Practice06() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("C");
        c.setLayout(null);  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setSize(20,20);
        label.setLocation(100,100);
        label.setOpaque(true);
        label.setBackground(Color.yellow);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (int)(Math.random()*350+50);
                int y = (int)(Math.random()*350+50);
                label.setLocation(x,y);
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice06();
    }
}
