import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice05 extends JFrame {
    private JSlider sliderList[] = new JSlider[3];
    public Practice05() throws HeadlessException {
        this.setTitle("Practice03");
        this.setSize(400,500);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

//        JSlider slider = new JSlider(100,200,0);
//        JLabel label = new JLabel("150");

        for(int i=0; i<3; i++){
            sliderList[i]= new JSlider(0,255,255);
            sliderList[i].setPaintTrack(true);
            sliderList[i].setPaintTicks(true);
            sliderList[i].setPaintLabels(true);
            sliderList[i].setMajorTickSpacing(50);
            sliderList[i].setMinorTickSpacing(10);
            c.add(sliderList[i]);
            sliderList[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int r = sliderList[0].getValue();
                    int g = sliderList[1].getValue();
                    int b = sliderList[2].getValue();
                    c.setBackground(new Color(r,g,b));
                }
            });

        }

//        JSlider rSlider = new JSlider(0,255,0);
//        JSlider gSlider = new JSlider(0,255,0);
//        JSlider bSlider = new JSlider(0,255,0);




//        slider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                label.setText(Integer.toString(slider.getValue()));
//            }
//        });


//        c.add(slider);
//        c.add(label);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice05();
    }
}
