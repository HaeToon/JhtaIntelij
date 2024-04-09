import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Shake implements Runnable{

    @Override
    public void run() {
        while(true){

        }
    }
}
public class Practice04 extends JFrame {
    int y=0;
    public Practice04() throws HeadlessException {
        this.setTitle("진동하는 프레임 만들기");
        while(true){
            y=(int)(Math.random()*10);
            this.setSize(400+y,400);
            Container c = this.getContentPane();

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }



    }

    public static void main(String[] args) {
        new Practice04();
    }
}
