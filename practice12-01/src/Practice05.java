import javax.swing.*;
import java.awt.*;
class ShakeLabel extends JLabel implements Runnable{
    private JLabel label;
    private Component component;

    public ShakeLabel(Component component) {
        this.component = component;
    }

    public ShakeLabel(JLabel label) {
        this.label = label;
        this.setSize(200,200);
    }

    @Override
    public void run() {
        while(true){
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);

            label.setLocation(100+x,100+y);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Practice05 extends JFrame {
    public Practice05() throws HeadlessException {
        this.setTitle("ShakeLabel");
        this.setSize(500, 500);

        Container c = this.getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("덜덜덜덜");
        label.setFont(new Font("맑은고딕",Font.BOLD,48));
        label.setSize(200,200);


        ShakeLabel shakeLabel = new ShakeLabel(label);
        shakeLabel.run();
        c.add(shakeLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice05();
    }
}
