import javax.swing.*;
import java.awt.*;

public class Practice02 extends JFrame {
    public Practice02(){
        this.setTitle("BorderLayout Practice");
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(5,7));
        JButton jButtonN = new JButton("North");
        JButton jButtonS = new JButton("South");
        JButton jButtonW = new JButton("West");
        JButton jButtonE = new JButton("East");
        JButton jButtonC = new JButton("Center");
        container.add(jButtonN,BorderLayout.NORTH);
        container.add(jButtonS,BorderLayout.SOUTH);
        container.add(jButtonW,BorderLayout.WEST);
        container.add(jButtonE,BorderLayout.EAST);
        container.add(jButtonC,BorderLayout.CENTER);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        Practice02 practice02 = new Practice02();
    }
}
