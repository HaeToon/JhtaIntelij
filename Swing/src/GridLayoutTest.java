import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame {
    public GridLayoutTest() {
        this.setTitle("Grid Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT_ON _CLOSE 닫기 눌렀을때 메모리상에서 사라짐.
        this.setSize(300,300);


        Container container = this.getContentPane();
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
//        container.setLayout(new FlowLayout()); // 옆으로가는것
        //BorderLayout / FlowLayout / GridLayout


        container.setLayout(new GridLayout(4,2,10,10));
        JLabel label01 = new JLabel("이름");
        JTextField textField01 = new JTextField(10);

        container.add(label01); //동서남북 배치
        container.add(textField01);
        container.add(new JTextField("학번"));
        container.add(new JTextField(10));
        container.add(new JTextField("학번"));
        container.add(new JTextField(10));
        container.add(new JTextField("학번"));
        container.add(new JTextField(10));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutTest();
    }
}
