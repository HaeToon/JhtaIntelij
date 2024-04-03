package practice02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Practice0203 extends JFrame {
    public Practice0203() throws HeadlessException {
        this.setTitle("Training02 JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.green);
        JLabel label = new JLabel("label");
        c.add(label);

        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                c.setBackground(Color.green);
                label.setText("Event Waiting");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        c.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                c.setBackground(Color.yellow);
                label.setText("Mouse Dragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0203();
    }
}
