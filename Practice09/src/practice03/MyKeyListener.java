package practice03;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
        System.out.println(e.getKeyCode());
        System.out.println(e.getKeyChar());
        if(e.getKeyCode()== KeyEvent.VK_LEFT){


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
