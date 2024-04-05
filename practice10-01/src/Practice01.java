import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Practice01 extends JFrame {
    public Practice01() throws HeadlessException {
        this.setTitle("Checkbox Practice01");
        this.setSize(300,200);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());


        JCheckBox able = new JCheckBox("버튼 비활성화");
        JCheckBox hidden = new JCheckBox("버튼 감추기");
        JButton test = new JButton("text button");

        able.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                if(e.getStateChange()==1){
                    test.setEnabled(false);
                }else {
                    test.setEnabled(true);
                }
            }
        });
        hidden.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    test.setVisible(false);
                }else {
                    test.setVisible(true);
                }
            }
        });

        c.add(able);
        c.add(hidden);
        c.add(test);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}
