import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class ImagePanel08 extends JPanel {

    public ImagePanel08() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.blue);
        g.fillArc(200,100,400,400,0,90);
        g.setColor(Color.magenta);
        g.fillArc(200,100,400,400,90,90);
        g.setColor(Color.red);
        g.fillArc(200,100,400,400,180,90);
        g.setColor(Color.orange);
        g.fillArc(200,100,400,400,270,90);
    }
}
class NorthPanel extends JPanel{
    public NorthPanel() {
        this.setLayout(new FlowLayout());
        this.setFont(new Font("맑은 고딕",Font.BOLD,20));
        this.setBackground(Color.lightGray);
        JLabel apple = new JLabel("apple");
        JTextField appleT=new JTextField(10);
        JLabel cherry = new JLabel("cherry");
        JTextField cherryT=new JTextField(10);
        JLabel strawberry = new JLabel("strawberry");
        JTextField strawberryT=new JTextField(10);
        JLabel banana = new JLabel("banana");
        JTextField bananaT=new JTextField(10);

        this.add(apple);
        this.add(appleT);
        this.add(cherry);
        this.add(cherryT);
        this.add(strawberry);
        this.add(strawberryT);
        this.add(banana);
        this.add(bananaT);
        int num = 0;
        JLabel appleN = new JLabel("apple"+num+"%");
        JLabel cherryN = new JLabel("cherry"+num+"%");
        JLabel strawberryN = new JLabel("strawberry"+num+"%");
        JLabel bananaN = new JLabel("banana"+num+"%");
        this.add(appleN);
        this.add(cherryN);
        this.add(strawberryN);
        this.add(bananaN);
        appleT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력된것=="+appleT.getText());
                appleN.setText("apple"+appleT.getText()+"%");

            }
        });
        cherryT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력된것=="+cherryT.getText());
                cherryN.setText("cherry"+cherryT.getText()+"%");
            }
        });
        strawberryT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력된것=="+strawberryT.getText());
                strawberryN.setText("strawberry"+strawberryT.getText()+"%");
            }
        });
        bananaT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력된것=="+bananaT.getText());
                bananaN.setText("banana"+bananaT.getText()+"%");
            }
        });




    }
}

public class Practice09 extends JFrame {
    public Practice09() throws HeadlessException {
        this.setTitle("Circle piece");
        this.setSize(800, 800);

        ImagePanel08 imagePanel = new ImagePanel08();
        this.setContentPane(imagePanel);
        NorthPanel northPanel = new NorthPanel();
        this.add(northPanel);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice09();
    }
}
