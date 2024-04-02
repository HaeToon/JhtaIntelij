import java.time.LocalTime;
import java.util.Calendar;

public class GoodMorning {
    public static void main(String[] args) {
/*Calendar 객체를 생성하면 현재 시간을 알 수 있다.
   프로그램을 실행한 현재 시간이 새벽 4시에서 낮 12시 이전이면 "Good Morning"을,
   오후 6시 이전이면 "Good Afternoon"을, 밤 10시 이전이면 "Good Evening"을,
   그 이후는 "Good Night"을 출력하는 프로그램을 작성하라.*/
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        if(hour>4 && hour<12) {
            System.out.println("Good Morning");
        }else if(hour>=12 && hour<18) {
            System.out.println("Good Afternoon");
        }else if(hour>=18 && hour<22) {
            System.out.println("Good Evening");
        }else {
            System.out.println("Good Night");
        }
    }
}
