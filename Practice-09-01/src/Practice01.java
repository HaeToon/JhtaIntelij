import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice01 extends JFrame {
    public Practice01() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("label");
        c.setLayout(new FlowLayout());  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setOpaque(true);
        label.setBackground(Color.yellow);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //Mouse 가 올라갔을때
//                JLabel target = (JLabel)e.getSource();  외부클래스에서 호출할때 e.getSource() 가 이벤트가 발생하는 것을 가리킴
//                target.setText("Love Java");
                label.setText("Love Java");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                //Mouse 내려갔을때
                label.setText("사랑해");
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}
