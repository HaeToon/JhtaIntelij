import javax.swing.*;
import java.awt.*;
public class RunnableTest03 extends JFrame implements Runnable{
    JLabel jLabel = new JLabel(Integer.toString(0)); //접근을위해 전역변수로 만듬

    public RunnableTest03() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(200,200);

        Container c = this.getContentPane();
        Thread thread = new Thread(this);

        jLabel.setFont(new Font("맑은 고딕",Font.BOLD,32));
        jLabel.setHorizontalAlignment(JLabel.CENTER);

        thread.start();
        //thread 를 만들어야 매초를 카운트함.

        c.add(jLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RunnableTest03();
    }

    int i=0;
    @Override
    public void run() {
        while(true){
            System.out.println(i);
            i++;
            jLabel.setText(Integer.toString(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {  //run을 종료시킬때 InterruptedException try catch 해줭야함.
                throw new RuntimeException(e);
            }
        }
    }
}
