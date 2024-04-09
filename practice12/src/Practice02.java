import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ContentPanel extends JPanel{
    private int x;
    private int y;
    public ContentPanel() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("클릭됨");
                 x = (int)(Math.random()*400);
                 y = (int)(Math.random()*400);
                 repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(x,y,50,50);
    }
}
public class Practice02 extends JFrame {
    private ContentPanel contentPanel = new ContentPanel();
    public Practice02() throws HeadlessException {
        this.setTitle("0.5sec Circle");
        this.setSize(500,700);

        Container c = this.getContentPane();
        this.setContentPane(contentPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
