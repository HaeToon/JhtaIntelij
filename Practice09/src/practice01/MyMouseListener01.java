package practice01;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MyMouseListener01 implements java.awt.event.MouseListener {
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
        JLabel label = (JLabel)e.getSource();
        label.setText("Java Love");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        label.setText("사랑해");
    }
}
