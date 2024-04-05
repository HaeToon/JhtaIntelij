import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Practice06 extends JFrame {
    private JSlider sliderList[] = new JSlider[3];
    public Practice06() throws HeadlessException {
        this.setTitle("Practice03");
        this.setSize(500,500);
        Container c = this.getContentPane();

        JLabel label = new JLabel("I Love Java");
        JSlider slider = new JSlider(0,200,10);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(4);







        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setFont(new Font("Arial",Font.BOLD,slider.getValue()));
            }
        });


        c.add(slider,BorderLayout.NORTH);
        c.add(label,BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice06();
    }
}
