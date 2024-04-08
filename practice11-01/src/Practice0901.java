import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class InputPanel extends JPanel{
    private String titleList[] = {"apple","cherry","strawberry","prune"};
    private JTextField textFiend[] = new JTextField[4];
    ImagePanel09 imagePanel09 = new ImagePanel09();


    public InputPanel() { //default = flowlayout
        this.setBackground(Color.lightGray);
        for(int i=0; i<4; i++){
            this.add(new JLabel(titleList[i]));
            textFiend[i]=new JTextField(5);
            this.add(textFiend[i]);
            textFiend[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if(e.getKeyCode()==KeyEvent.VK_ENTER){
                        System.out.println("엔터누름");
                        imagePanel09.arcList[0]=10;
                        imagePanel09.arcList[1]=10;
                        imagePanel09.arcList[2]=10;
                        imagePanel09.arcList[3]=10;
                        //이부분만 해결하면 됨
                        imagePanel09.repaint();
                        //배열만들고 repaint

                    }
                }
            });
        }

    }

}
class ImagePanel09 extends JPanel {
    public int arcList[]= new int[4];
    private Color colors[] = {Color.red,Color.green,Color.blue,Color.orange};
    private int num=0;
    int sum=0;
    public ImagePanel09() {
        System.out.println(Arrays.toString(arcList));
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("repaint에 의해 호출됨");
    super.paintComponent(g);
    for(int k=0; k<4; k++){
        sum+=arcList[k];
    }
        for (int j=0; j<4; j++){
            arcList[j]=Math.round((float)(arcList[j])/sum*360);
        }
       System.out.println(Arrays.toString(arcList));
   for(int i=0; i<4; i++){
       g.setColor(colors[i]);
       g.fillArc(200,100,400,400,num,arcList[i]);
       num+=arcList[i];
   }

    }
}
public class Practice0901 extends JFrame {
    private ImagePanel09 graphicsPanel = new ImagePanel09();
    public Practice0901() throws HeadlessException {
        this.setTitle("Color Circle");
        this.setSize(800, 600);

     Container c = this.getContentPane();
     c.add(new InputPanel(),BorderLayout.NORTH);
     c.add(new ImagePanel09(),BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0901();
    }
}
