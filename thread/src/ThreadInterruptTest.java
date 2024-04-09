import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerLabel implements Runnable {
    private JLabel label;
    private boolean isEnd=false; // 속성은 Private로 만들고 변경은 method(){}로 한다.

    public TimerLabel(JLabel label) {
        this.label = label;
    }
public void end(){
        isEnd=true;
}
    @Override
    public void run() {
        //여기에 무한루프 구현
        int num = 0;
        while (true) {
            num++;
            label.setText(Integer.toString(num));
            try {
                Thread.sleep(100);
                if(isEnd){
                    return;
                }
//                if(num==30){
//                    return;
//                }
            } catch (InterruptedException e) {
                System.out.println("예외발생!");
                return;
//                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadInterruptTest extends JFrame {
    Thread thread = null;
    private boolean isEnd = true;
    public ThreadInterruptTest() throws HeadlessException {
        this.setTitle("깜빡이");
        this.setSize(200, 200);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));


        JLabel label01 = new JLabel("Hello");
        c.add(label01);
        label01.setFont(new Font("맑은 고딕", Font.BOLD, 36));

        JButton btn = new JButton("timer stop");
        c.add(btn);
        TimerLabel timerLabel = new TimerLabel(label01);
        thread = new Thread(timerLabel);
        thread.start();
        //thread.start 는 재활용이안됨.
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("클릭");
                //클릭시 예외발생 try catch의 예외인 catch문
                //thread는 종료하면 끝. 재활용안됨. 또쓰려면 새로운 thread를 다시 만들어야함.(new Thread)
//                thread.interrupt();
//                  timerLabel.end();
                  if(isEnd){
                      thread.interrupt();
                  }else {
                      thread = new Thread(timerLabel);
                      thread.start();
                  }
                  isEnd=!isEnd;
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ThreadInterruptTest();
    }
}
