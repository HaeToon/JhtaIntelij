import javax.swing.*;
import java.awt.*;

public class Practice04 extends JFrame {
    public Practice04(){
        this.setTitle("Background Color Practice");
        this.setSize(600,400);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,10,0,0));
        JButton btns[]= new JButton[10];
        Color colors[] = {Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue,Color.magenta,Color.darkGray,Color.pink,Color.lightGray};
        for(int i=0; i<10; i++) {
            btns[i]=new JButton(Integer.toString(i));
            btns[i].setOpaque(true);
            btns[i].setBackground(colors[i%10]);
            container.add(btns[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice04 practice04 = new Practice04();
    }
}
