import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class Bubble extends JLabel implements Runnable{
    BubblePanel bubblePanel;
    public Bubble(BubblePanel bubblePanel ,int posX, int posY) {
        System.out.println("나는 풍선 레이블");
        ImageIcon imageIcon = new ImageIcon("image/balloon.png");
        this.setIcon(imageIcon);
        this.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
        this.setLocation(posX-imageIcon.getIconWidth()/2,posY -imageIcon.getIconHeight()/2);
        bubblePanel.add(this);
        Thread thread = new Thread(this);
        thread.start();
        this.bubblePanel=bubblePanel;
    }
    @Override
    public void run() {
        double theta = 0;
        int loadX = getX();
        int loadY = getY();
        int first = getX();
        int ratio = (int)(Math.random()*70);
        while(true){
        theta+=0.05;
        loadX=(int)(Math.sin(theta)*ratio);
            loadY-=1;
            this.setLocation(first+loadX,loadY); //thread 지워야함.
            if(loadY<50){ //화면에 더이상 없을때
                bubblePanel.remove(this);
//                repaint();
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//JLabel (new ImageIcon("asdasd/asda/asd.png"))
class BubblePanel extends JPanel{
//    class Bubble extends JLabel implements Runnable{
//        public Bubble(int posX, int posY) {
//            System.out.println("나는 풍선 레이블");
//            ImageIcon imageIcon = new ImageIcon("image/balloon.png");
//            this.setIcon(imageIcon);
//            this.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
//            this.setLocation(posX-imageIcon.getIconWidth()/2,posY -imageIcon.getIconHeight()/2);
//            Thread thread = new Thread(this);
//            thread.start();
//        }
//        @Override
//        public void run() {
//            int loadX = this.getX();
//            int loadY = getY();
//            while(true){
//                loadY-=2;
//                this.setLocation(loadX,loadY); //thread 지워야함.
//                if(loadY<50){ //화면에 더이상 없을때
//                    BubblePanel.this.remove(this);
////                    BubblePanel.this.repaint();
//                    return;
//                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
    public BubblePanel() {
        //여기다가 JLabel (ImageIcon)
        System.out.println("BubblePanel 생성");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //클릭할때마다 JLabel 생성후 여기에 앉히기
                System.out.println("클릭");
               Bubble bubble = new Bubble(BubblePanel.this,e.getX(),e.getY());
//               BubblePanel.this.add(bubble);
//                add(bubble);
                repaint();
            }
        });
        this.setLayout(null);

    }
}
public class Practice06 extends JFrame {
    public Practice06() throws HeadlessException {
        this.setTitle("balloon");
        this.setSize(500, 500);

        this.setContentPane(new BubblePanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice06();
    }
}
