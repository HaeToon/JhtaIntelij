import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImagePanel extends JPanel{
    ImageIcon imageIcon = new ImageIcon("C:\\Users\\jhta\\Desktop\\ham.jpg");
    Image image = imageIcon.getImage();
    private int posX=100;
    private int posY=100;

    Point point = new Point();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        g.fillOval(posX,posY,20,20);
        g.setColor(new Color(255,0,0));
    }

    public ImagePanel() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                posX = e.getX()-10;
                posY= e.getY()-10;
                repaint();
            }
        });
    }
}
public class Practice02 extends JFrame {
    public Practice02() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(500,500);

        ImagePanel imagePanel = new ImagePanel();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
