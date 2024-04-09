import javax.swing.*;
import java.awt.*;
class TimerRunnable02 implements Runnable{
    //접근을 위해 외부클래스에서 내부클래스로 이동함.
    private JLabel TimerLabel;

    public TimerRunnable02 (JLabel jLabel){
        this.TimerLabel = jLabel;
    }

    int i=0;
    @Override
    public void run() {
        while(true){
            System.out.println(i);
            i++;
            TimerLabel.setText(Integer.toString(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {  //run을 종료시킬때 InterruptedException try catch 해줭야함.
                throw new RuntimeException(e);
            }
        }
    }
}
public class RunnableTest02 extends JFrame {
    JLabel jLabel = new JLabel(Integer.toString(0)); //접근을위해 전역변수로 만듬

    public RunnableTest02() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(200,200);

        TimerRunnable02 timerRunnable = new TimerRunnable02(jLabel);
        Thread thread = new Thread(timerRunnable);
        thread.start();
        Container c = this.getContentPane();


        jLabel.setFont(new Font("맑은 고딕",Font.BOLD,32));
        jLabel.setHorizontalAlignment(JLabel.CENTER);

        //thread 를 만들어야 매초를 카운트함.

        c.add(jLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RunnableTest02();
    }
}
