import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImagePanel02 extends JPanel{
    ImageIcon imageIcon = new ImageIcon("C:\\Users\\jhta\\Desktop\\images\\1.png");
    Image image = imageIcon.getImage();
    private int posX=100;
    private int posY=100;

    Point point = new Point();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,posX,posY,this);
    }

    public ImagePanel02() {
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
public class Practice03 extends JFrame {
    public Practice03() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(500,500);

        ImagePanel02 imagePanel = new ImagePanel02();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
