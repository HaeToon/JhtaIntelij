import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxTest extends JFrame {
    public CheckBoxTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400,400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());

        JCheckBox checkBox01 = new JCheckBox("사과");
        JCheckBox checkBox02 = new JCheckBox("바나나");
        JCheckBox checkBox03 = new JCheckBox("딸기");
        checkBox01.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                if(e.getStateChange()==ItemEvent.SELECTED){
                    System.out.println("check");
                }else {
                    System.out.println("uncheck");
                }
            }
        });
        c.add(checkBox01);
        c.add(checkBox02);
        c.add(checkBox03);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}