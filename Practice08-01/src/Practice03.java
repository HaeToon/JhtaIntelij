import javax.swing.*;
import java.awt.*;

public class Practice03 extends JFrame {
    public Practice03() {
        this.setTitle("GridLayout Practice");
        this.setSize(600,400);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,10,0,0));
        for(int i=0; i<10; i++){
            container.add(new JButton(Integer.toString(i)));
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice03 practice03 = new Practice03();
    }
}
