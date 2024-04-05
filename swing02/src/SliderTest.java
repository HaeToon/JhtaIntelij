import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SliderTest extends JFrame {
    private String fruits[]={"apple","banana","orange"};
    public SliderTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400, 400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());

        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
        c.add(slider);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing((10));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(slider.getValue());
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SliderTest();
    }
}