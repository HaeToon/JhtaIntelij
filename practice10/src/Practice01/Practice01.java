package Practice01;

import javax.swing.*;
import java.awt.*;

public class Practice01 extends JFrame {
    public Practice01() throws HeadlessException {
        this.setTitle("CheckBox Practice01");
        this.setSize(250,200);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JCheckBox able = new JCheckBox("버튼 비활성화");
        JCheckBox hidden = new JCheckBox("버튼 숨기기");
        JButton test = new JButton("test button");

        c.add(able);
        c.add(hidden);
        c.add(hidden);

        MyEventListener myEventListener = new MyEventListener();
        able.addItemListener(myEventListener);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}
