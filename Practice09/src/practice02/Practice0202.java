package practice02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Practice0202 extends JFrame {
    private JLabel label = new JLabel("label");
    public Practice0202() throws HeadlessException {
        this.setTitle("Training02 JLabel");
        this.setSize(400,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.green);
        label = new JLabel("label");
        c.add(label);
        MouseListener mouseListener = new MouseListener();
        c.addMouseListener(mouseListener);
        c.addMouseMotionListener(mouseListener);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
    class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Container c = (Container) e.getSource();
            label.setText("Mouse Event Waiting");
            c.setBackground(Color.green);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Container c = (Container) e.getSource();
            label.setText("Mouse Dragged");
            c.setBackground(Color.yellow);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}