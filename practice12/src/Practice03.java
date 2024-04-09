import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

class TimerLabel implements Runnable {
    private JLabel label;
    private int time = 0;

    public TimerLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        while (true) {
            LocalTime now =LocalTime.now();
            label.setText(now.getHour()+"시"+now.getMinute()+"분"+now.getSecond()+"초");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Practice03 extends JFrame {
    Thread thread = null;

    public Practice03() throws HeadlessException {
        this.setTitle("Timer");
        this.setSize(300, 300);

        Container c = this.getContentPane();

        JLabel label01 = new JLabel();
        label01.setHorizontalAlignment(JLabel.CENTER);
        c.add(label01, BorderLayout.CENTER);
        label01.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        TimerLabel timerLabel = new TimerLabel(label01);
        thread = new Thread(timerLabel);
        thread.start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
