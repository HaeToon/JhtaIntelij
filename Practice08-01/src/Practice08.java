import javax.swing.*;
import java.awt.*;
class NorthPanel02 extends JPanel{
    public NorthPanel02(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); //JPanel 은 Layout이 FlowLayout이 default임.
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        this.add(new JButton("Open"));
        this.add(new JButton("Close"));
        this.add(new JButton("Exit"));
    }
}
class CenterPanel02 extends JPanel{
    public CenterPanel02(){
        this.setLayout(null);
        for(int i=0; i<20; i++){
            int x = (int)(Math.random()*300+50);
            int y = (int)(Math.random()*300+50);
            JLabel label = new JLabel("*");
            label.setSize(20,20);
            label.setForeground(Color.yellow);
            label.setLocation(x,y);
            this.add(label);
        }
    }
}
class SouthPanel02 extends JPanel{
    public SouthPanel02(){
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        this.add(new JLabel("Integer Input"));
        this.add(new JTextField(20)); // 20글자 들어가게끔 columns 에 int삽입
    }
}
public class Practice08 extends JFrame {
    public Practice08() {
        this.setTitle("여러개의패널을가진프레임");
        this.setSize(400,500);
        Container c = this.getContentPane();
        c.add(new NorthPanel02(),BorderLayout.NORTH);
        c.add(new SouthPanel02(),BorderLayout.SOUTH);
        c.add(new CenterPanel02(),BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice08 p = new Practice08();
    }
}
