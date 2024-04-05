package practice03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Container c = (Container) e.getSource();
        JLabel label = (JLabel)e.getSource();
        StringBuffer stringBuffer = new StringBuffer(label.getText());
        String reversedText = stringBuffer.reverse().toString();
        label.setText(reversedText);
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

