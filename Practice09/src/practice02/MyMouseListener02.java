package practice02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener02 implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Container c = (Container) e.getSource();
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
        c.setBackground(Color.yellow);

    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
