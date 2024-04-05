import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioTest extends JFrame {
    public RadioTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400,400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());

        JRadioButton radioBox01 = new JRadioButton("사과");
        JRadioButton radioBox02 = new JRadioButton("바나나");
        JRadioButton radioBox03 = new JRadioButton("딸기");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioBox01);
        radioGroup.add(radioBox02);
        radioGroup.add(radioBox03);
        radioBox01.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                System.out.println(radioBox01.isSelected());
                if(e.getStateChange()==ItemEvent.SELECTED){
                    System.out.println("check");
                }else {
                    System.out.println("uncheck");
                }
            }
        });
        c.add(radioBox01);
        c.add(radioBox02);
        c.add(radioBox03);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RadioTest();
    }
}