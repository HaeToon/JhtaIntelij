import javax.swing.*;
import java.awt.*;

public class Practice03 extends JFrame {

   class NorthPanel extends JPanel{
       public NorthPanel() {
           this.setLayout(new FlowLayout());
           this.add(new JLabel("금액"));
           this.add(new JTextField(10));
           this.add(new JButton("change"));
           this.setVisible(true);
       }
   }
    class CenterPanel extends JPanel{
        public CenterPanel() {
            this.setLayout(new GridLayout(8,2,0,10));
            this.add(new JLabel("오만원"));
            this.add(new JTextField(10));
            this.add(new JLabel("만원"));
            this.add(new JTextField(10));
            this.add(new JLabel("오천원"));
            this.add(new JTextField(10));
            this.add(new JLabel("천원"));
            this.add(new JTextField(10));
            this.add(new JLabel("오백원"));
            this.add(new JTextField(10));
            this.add(new JLabel("백원"));
            this.add(new JTextField(10));
            this.add(new JLabel("오십원"));
            this.add(new JTextField(10));
            this.add(new JLabel("십원"));
            this.add(new JTextField(10));
            this.setVisible(true);
        }
    }
    public Practice03() throws HeadlessException {
        this.setTitle("화폐교환기");
        this.setSize(400,600);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JPanel center = new JPanel();


        c.add(new NorthPanel(),BorderLayout.NORTH);
        c.add(new CenterPanel(),BorderLayout.CENTER);





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
