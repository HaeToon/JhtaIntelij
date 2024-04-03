import javax.swing.*;
import java.awt.*;

public class Practice02 extends JFrame {
    public Practice02(){  //버튼 집어넣기
        this.setTitle("BoderLayout Practice");
        this.setSize(400,200);
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(5,7));
       container.add(new JButton("North"),BorderLayout.NORTH);
       container.add(new JButton("South"),BorderLayout.SOUTH);
       container.add(new JButton("West"),BorderLayout.WEST);
       container.add(new JButton("East"),BorderLayout.EAST);
       container.add(new JButton("Center"),BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice02 practice02 = new Practice02();
    }
}
