package practice03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Practice0303 extends JFrame {
    public Practice0303() throws HeadlessException {
        this.setTitle("Left키로 문자열 교체");
        this.setSize(600,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel("Java Love");
        c.add(label);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String str = label.getText();
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(str.equals("Java Love")){
                        label.setText("avaJ evoL");
                    }else if (str.equals("avaJ evoL")){
                        label.setText("Java Love");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        c.addKeyListener(keyListener);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
    }

    public static void main(String[] args) {
        new Practice0303();
    }
}
