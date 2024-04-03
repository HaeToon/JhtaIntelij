import javax.swing.*;
import java.awt.*;
class NorthPanel extends JPanel{
    public NorthPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); //JPanel 은 Layout이 FlowLayout이 default임.
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        this.add(new JLabel("수식입력"));
        this.add(new JTextField(20)); // 20글자 들어가게끔 columns 에 int삽입
    }
}
class CenterPanel extends JPanel{
    public CenterPanel(){
        this.setLayout(new GridLayout(4,4,5,5));
        this.setOpaque(true);
        this.setBackground(Color.white);
        String btns[] = {"0","1","2","3","4","5","6","7","8","9","CE","계산","+","-","X","%"};
       for(int i=0; i<16; i++){
           JButton jButton = new JButton(btns[i]);
           this.add(jButton);
       }
    }
}
class SouthPanel extends JPanel{
    public SouthPanel(){
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        this.add(new JLabel("계산결과"));
        this.add(new JTextField(20)); // 20글자 들어가게끔 columns 에 int삽입
    }
}
public class Practice07 extends JFrame {
    public Practice07() {
        this.setTitle("계산기");
        this.setSize(400,500);
        Container c = this.getContentPane();
        c.add(new NorthPanel(),BorderLayout.NORTH);
        c.add(new SouthPanel(),BorderLayout.SOUTH);
        c.add(new CenterPanel(),BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice07 p = new Practice07();
    }
}
