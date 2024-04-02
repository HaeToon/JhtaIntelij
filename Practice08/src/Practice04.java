import javax.swing.*;
import java.awt.*;

public class Practice04 extends JFrame {
    public Practice04() {
        this.setTitle("GridLayout Practice");
        this.setSize(700,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,10,0,0));
        Color arr[] = {Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue,Color.magenta,Color.darkGray,Color.pink,Color.gray};
        for(int i=0; i<10; i++) {
            JButton jButton = new JButton(Integer.toString(i));
            container.add(jButton);
            jButton.setBackground(arr[i]);
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice04 practice04 = new Practice04();
    }
}
