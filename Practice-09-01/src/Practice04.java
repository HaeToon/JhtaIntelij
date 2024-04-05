import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Practice04 extends JFrame {
    public Practice04() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("Love Java");
        c.setLayout(new FlowLayout());  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setBackground(Color.yellow);
        label.setOpaque(true);
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String first = label.getText().substring(0,1);
                String rest = label.getText().substring(1);
                label.setText(rest+first);
//                label.setText(rest.concat(first)); + 를사용하지않으려면 concat method를 사용하면 된다.

            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new Practice04();
    }
}
