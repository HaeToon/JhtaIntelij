package practice01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Practice0103 extends JFrame {
    public Practice0103() throws HeadlessException {
        this.setTitle("Training JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel("label");
        c.add(label);

        label.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("사랑해");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Love java");
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0103();
    }
}
