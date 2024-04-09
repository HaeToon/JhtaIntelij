import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CirclePanel extends JPanel implements Runnable {
    private int posX,posY;
    Thread thread=null;

    public CirclePanel() {
//        Thread thread = new Thread(this);
//        thread.start();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(thread==null){
                    thread = new Thread(CirclePanel.this);
                    thread.start();
                }
                repaint();
            }
        });
    }

    @Override
    public void run() {
        while(true){

            posX=(int)(Math.random()*this.getWidth());
            posY=(int)(Math.random()*this.getHeight());
//            this.repaint();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255,0,255));
        g.drawOval(posX,posY,50,50);
    }
}
public class Practice02 extends JFrame {
    public Practice02() throws HeadlessException {
        this.setTitle("Random Circle");
        this.setSize(500,500);

        this.setContentPane(new CirclePanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Practice02();
    }
}
