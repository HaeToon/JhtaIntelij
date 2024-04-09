import javax.swing.*;
import java.awt.*;
class FlickingLabelQuiz03 extends Thread {
    private JLabel FlickingLabelQ;
    private int delay;
    public FlickingLabelQuiz03(JLabel label,int delay) {
        this.delay = delay;
        this.FlickingLabelQ=label;
        FlickingLabelQ.setBackground(Color.orange);
        FlickingLabelQ.setOpaque(true);
        this.start();
        //run 메서드를 종료하는 방법
        //thread 를 멈추는방법 return 던지기
    }

    @Override
    public void run() {
        boolean isFlick = false;
        while (true) {
            //여기에 움직일것들
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                return;
            }
            isFlick=!isFlick;
            if (isFlick == true) {
                FlickingLabelQ.setBackground(Color.green);
            } else {
                FlickingLabelQ.setBackground(Color.orange);
            }
        }
    }
}
public class Quiz03 extends JFrame {

    public Quiz03() throws HeadlessException {
        this.setTitle("깜빡이");
        this.setSize(200, 200);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel label01 = new JLabel("Hello");
        JLabel label02 = new JLabel("World");

        c.add(label01);
        c.add(label02);

        new FlickingLabelQuiz03(label01,500);
        new FlickingLabelQuiz03(label02,1000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Quiz03();
    }
}
