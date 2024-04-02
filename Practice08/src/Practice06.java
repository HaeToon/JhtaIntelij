import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Practice06 extends JFrame {
    public Practice06() throws HeadlessException {
        this.setTitle("NullLayout Practice");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);
        JPanel jPanel = new JPanel();
        jPanel.setSize(250,250);
        jPanel.setBackground(Color.lightGray);
        jPanel.setLocation(25,25);
//        this.setContentPane(jPanel);
//        jPanel.setLayout(new BorderLayout(50,50));
        container.add(jPanel,BorderLayout.CENTER);
        for(int i=0; i<20; i++){
            int randomX = (int)(Math.random()*250+1);
            int randomY = (int)(Math.random()*250+1);
            JLabel jLabel = new JLabel(Integer.toString(randomX));
            jLabel.setLocation(randomX,randomY);
            jLabel.setSize(20,20);
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.red);
            jPanel.add(jLabel);

        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice06 practice06 = new Practice06();
    }
}
