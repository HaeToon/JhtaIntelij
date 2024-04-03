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
        Practice01MouseListener practice01MouseListener = new Practice01MouseListener();
        label.addMouseListener(practice01MouseListener);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
    class Practice01MouseListener implements MouseListener {

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
                label.setText("Love Java");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            label.setText("사랑해");
        }
    }

}
