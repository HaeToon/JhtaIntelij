import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Quiz04 extends JFrame implements Runnable{
    Container c=null;
    Thread thread;
    private boolean isEnd;
    public Quiz04() throws HeadlessException {
        this.setTitle("깜빡이");
        this.setSize(500, 500);

        c = this.getContentPane();
        c.setLayout(null);

        thread = new Thread(this);
        thread.start();
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("클릭끄");
//                thread.interrupt();  // isEnd와 같음.
                isEnd=true;
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Quiz04();
    }

    @Override
    public void run() {
        while(true){
            int x = (int)(Math.random()*c.getWidth())-50;
            int y = (int)(Math.random()*c.getHeight())-50;
            JLabel label = new JLabel("Java");
            label.setSize(100,50);
            label.setLocation(x,y);
            c.add(label);
            c.repaint();
            try {
                Thread.sleep(300);
                if(isEnd){
                    c.removeAll();
                    c.repaint();
                    label = new JLabel("Finish");
                    label.setSize(100,50);
                    c.add(label);
                    label.setLocation(200,200);
                    return;
                }
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("예외발생");

                return;
            }
        }
    }
}

