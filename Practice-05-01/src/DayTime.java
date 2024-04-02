import java.time.LocalTime;
import java.util.Calendar;

public class DayTime {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        int todayHour = today.get(Calendar.HOUR_OF_DAY);
        if(todayHour>3 && todayHour<13) {
            System.out.println("Good Morning");
        }else if(todayHour>12&&todayHour<19) {
            System.out.println("Good Evening");
        }else {
            System.out.println("Good Night");
        }
    }
}
