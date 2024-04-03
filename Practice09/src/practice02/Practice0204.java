package practice02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice0204 extends JFrame {
    public Practice0204() throws HeadlessException {
        this.setTitle("Training02 JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.green);
        JLabel label = new JLabel("label");
        c.add(label);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                c.setBackground(Color.green);
                label.setText("Event Waiting");
            }
        });
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                c.setBackground(Color.yellow);
                label.setText("Mouse Dragged");
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0204();
    }
}
