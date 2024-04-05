import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice03 extends JFrame {
    public Practice03() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("Love Java");
        c.setLayout(new FlowLayout());  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setOpaque(true);
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                StringBuffer stringBuffer = new StringBuffer(label.getText());
                String reversedText = stringBuffer.reverse().toString();
                label.setText(reversedText);
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
