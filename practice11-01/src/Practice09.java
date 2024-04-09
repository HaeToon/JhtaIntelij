import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Practice09 extends JFrame {
    private String titleList[] = {"apple", "cherry", "strawberry", "prune"};
    private Color colors[] = {Color.red, Color.green, Color.blue, Color.orange};
    private JTextField textFiend[] = new JTextField[4];
    private ImagePanel09 imagePanel09 = new ImagePanel09();
    InputPanel inputPanel = new InputPanel();
    class InputPanel extends JPanel {
        public InputPanel() { //default = flowlayout
            this.setBackground(Color.lightGray);
            for (int i = 0; i < 4; i++) {
                this.add(new JLabel(titleList[i]));
                textFiend[i] = new JTextField("0",5);
                this.add(textFiend[i]);
                textFiend[i].addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            System.out.println("엔터누름");
                            imagePanel09.repaint();
                        }
                    }
                });
            }
        }
    }
    class ImagePanel09 extends JPanel {

        public int arcList[] = new int[4];
        @Override
        public void paintComponent(Graphics g) {
            int sum = 0;
            for(int i=0; i<4; i++){
                arcList[i]=Integer.parseInt(textFiend[i].getText());
                sum += arcList[i];
            }
            System.out.println("repaint에 의해 호출됨");
            super.paintComponent(g);
            g.setFont(new Font("맑은 고딕",Font.BOLD,20));
            for (int j = 0; j < 4; j++) {
                arcList[j] = Math.round((float) (arcList[j]) / sum * 360);
                g.drawString(titleList[j]+":"+Math.round((float) (arcList[j]) / (36/12))+"%",70+180*j,20);
            }
            System.out.println(Arrays.toString(arcList));
            int start = 90;
            for (int i = 0; i < 4; i++) {
                g.setColor(colors[i]);
                g.fillArc(200, 100, 400, 400, start, arcList[i]);
                start += arcList[i];
            }
        }
        public ImagePanel09() {
            System.out.println(Arrays.toString(arcList));
        }
    }
    public Practice09() throws HeadlessException {
        this.setTitle("Color Circle");
        this.setSize(800, 600);

        Container c = this.getContentPane();

        c.add(inputPanel, BorderLayout.NORTH);
        c.add(imagePanel09, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Practice09();
    }
}