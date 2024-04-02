import javax.swing.*;
import java.awt.*;

public class Practice07 extends JFrame {
    public Practice07(){
        this.setTitle("계산기 프레임");
        this.setSize(600,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        JLabel top = new JLabel("수식입력");
        JLabel bottom = new JLabel("계산결과");
        container.add(top,BorderLayout.NORTH);
        container.add(bottom,BorderLayout.SOUTH);
        JPanel center = new JPanel();
        container.add(center);
        for(int i=0; i<16; i++){
            JButton jButton = new JButton(Integer.toString(i));
            jButton.setLayout(new FlowLayout());
            container.add(jButton);
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice07 practice07 = new Practice07();
    }
}
