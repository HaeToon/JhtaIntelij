import javax.swing.*;
import java.awt.*;

public class Practice06 extends JFrame {
    public Practice06() {
        this.setTitle("9장6번문제");
        this.setSize(400, 400);
        Container c = this.getContentPane();
        c.setLayout(null);
        for(int i=0; i<20; i++){
            int ramdomX=(int)(Math.random()*300+50);
            int ramdomY=(int)(Math.random()*300+50);
            JLabel jLabel = new JLabel(Integer.toString(i));
            jLabel.setSize(20,20);
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.magenta);
            jLabel.setLocation(ramdomX,ramdomY);
            c.add(jLabel);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice06 practice06 = new Practice06();
    }
}
