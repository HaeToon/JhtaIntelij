import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImagePanel03 extends JPanel{
    ImageIcon imageIcon = new ImageIcon("C:\\Users\\jhta\\Desktop\\images\\1.png");
    Image image = imageIcon.getImage();
    private int posX=100;
    private int posY=100;
    private int sizeX=50;
    private int sizeY=50;

    Point point = new Point();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,posX,posY, sizeX,sizeY,this);

    }

    public ImagePanel03() {
        sizeX=image.getWidth(null);
        sizeY=image.getWidth(null);

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar()=='+'){
                    sizeX*=1.1;
                    sizeY*=1.1;
                    repaint();
                }if(e.getKeyChar()=='-'){
                    if(sizeX>10) {
                        sizeX -= 0.9;
                        sizeY -= 0.9;
                    }
                    repaint();
                }
            }
        });
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
public class Practice04 extends JFrame {
    public Practice04() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(500,500);

        ImagePanel03 imagePanel = new ImagePanel03();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice04();
    }
}
