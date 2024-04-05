import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice02 extends JFrame {
    public Practice02() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("label");
        c.setLayout(new FlowLayout());  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setOpaque(true);
        c.setBackground(Color.yellow);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //Mouse 가 내려갔을때
                label.setText("Mouse Released");
                c.setBackground(Color.green);
            }
        });
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //Mouse 가 드래그됬을때
                label.setText("Mouse Dragged");
                c.setBackground(Color.yellow);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
