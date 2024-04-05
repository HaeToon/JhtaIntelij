import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class ComboBoxTest extends JFrame {
    private String fruits[]={"apple","banana","orange"};
    public ComboBoxTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400, 400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());
        //ComboBox에는 배열 , Vector 를 넣을수있다.

        JComboBox<String> comboBox = new JComboBox<>(fruits); // 콤보박스
        JComboBox<String> comboBox02= new JComboBox<>(fruits); // 콤보박스
//        Vector<String> fruits = new Vector<>(Arryas.fruits02); // 콤보박스
        c.add(comboBox);
        c.add(comboBox02);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex());
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxTest();
    }
}