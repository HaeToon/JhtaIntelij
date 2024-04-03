import javax.swing.*;
import java.awt.*;

public class Practice05 extends JFrame{
    public Practice05() {
        this.setTitle("GridLayout 16ColorButton Practice");
        this.setSize(700,400);
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(4,4,0,0));
        JButton btns[]= new JButton[16];
        Color colors[] = {Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue,Color.magenta,Color.darkGray,Color.pink,Color.lightGray};
        for(int i=0; i<16; i++){
            btns[i]=new JButton(Integer.toString(i));
            btns[i].setOpaque(true);
            btns[i].setBackground(colors[i%10]);
            c.add(btns[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice05 practice05=new Practice05();
    }
}
