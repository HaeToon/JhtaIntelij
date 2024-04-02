import javax.swing.*;
import java.awt.*;

public class Practice05 extends JFrame {
    public Practice05() {
        this.setTitle("GridLayout Practice");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,4,0,0));
        Color arr[] = {Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue,Color.magenta,Color.darkGray,Color.pink,Color.gray,Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue};
        for(int i=0; i<16; i++){
            JButton jButton = new JButton(Integer.toString(i));
            container.add(jButton);
            jButton.setBackground(arr[i]);
        }

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice05 practice05 = new Practice05();
    }
}
