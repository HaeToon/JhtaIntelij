import javax.swing.*;
import java.awt.*;

public class ComponentTest extends JFrame {
    public ComponentTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400,400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\jhta\\Desktop\\2024-lecture\\js-lecture\\portfolio\\image\\07.webp"));
        JButton btn01 = new JButton("Blcak/White");
        JButton btn02 = new JButton("Enabled/Disabled");


        ImageIcon imageIcon= new ImageIcon("C:\\Users\\jhta\\Downloads\\clown.png");
        JButton btn03 = new JButton("",imageIcon);


        btn01.setFont(new Font("맑은 고딕",Font.BOLD,20));
        btn01.setMargin(new Insets(0,0,0,0)); //테두리
        btn01.setOpaque(true); // 불투명처리
//        btn01.setRolloverEnabled(false);
        btn01.setBackground(Color.black); //배경색
        btn01.setForeground(Color.white); //글자색
        btn01.setBorder(null);  //테두리?
        btn03.setBorder(null);  //테두리?
        btn01.setFocusPainted(false);
        btn01.setBorderPainted(false);
        c.add(btn01);
        c.add(btn02);
        c.add(btn03);
        c.add(imageLabel);
        btn02.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentTest();
    }
}
