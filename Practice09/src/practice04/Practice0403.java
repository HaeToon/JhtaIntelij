package practice04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Practice0403 extends JFrame {
    private JLabel label = new JLabel("Java Love");

    public Practice0403() throws HeadlessException {
        this.setTitle("Left키로 문자열 교체");
        this.setSize(600,400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(label);
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    String first =label.getText().substring(0,1);
                    String rest = label.getText().substring(1);
                    String text = rest + first;
                    label.setText(text);
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
        new Practice0403();

    }
}