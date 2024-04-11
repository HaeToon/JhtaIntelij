import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

class Clock extends JLabel implements Runnable {
    private Thread thread;

    public Clock() {
        this.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        this.setHorizontalAlignment(JLabel.CENTER);

        makeTile();

        thread = new Thread(this);
        thread.start();
    }
private void makeTile(){
//    Calendar calendar = Calendar.getInstance(); // Calendar의 객체를 얻어옴
//    int hour = calendar.get(Calendar.HOUR_OF_DAY);
//    int min = calendar.get(Calendar.MINUTE);
//    int sec = calendar.get(Calendar.SECOND);
    LocalTime localTime = LocalTime.now(); // 시간만 알수있음.
//    LocalDate localDate = LocalDate.now();// 날짜만알수있음
//    LocalDateTime localDateTime = LocalDateTime.now(); //날짜와 시간 둘다 알수있음
    int hour = localTime.getHour();
    int min = localTime.getMinute();
    int sec = localTime.getSecond();

    this.setText(addZero(hour)+":"+addZero(min)+":"+addZero(sec));
    if(hour<10){

    }
}
private String addZero(int num){
        if(num<10){
            return "0"+num;
        }else {
         return Integer.toString(num);
        }
}
    @Override
    public void run() { //thread.start로 인해 여기있는 코드가 반영된다.

        while (true) {
            makeTile();
//            System.out.println("시계를 출력합니다.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Practice03 extends JFrame {
    public Practice03() throws HeadlessException {
        this.setTitle("Clock");
        this.setSize(500, 500);
        //text기대문에 JLABEL
        Container c = this.getContentPane();
        c.add(new Clock());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
