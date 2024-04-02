import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void makeCalendar(int year, int month) { //달력만들기
        LocalDate localDate = LocalDate.of(year, month, 1);
        int lastDay = localDate.lengthOfMonth();              //어떤 요일부터 시작하는지 알아야함.
        int day = localDate.getDayOfWeek().getValue();        // 일요일0~토요일6
        System.out.println("3월은 무슨요일에서 시작하는가"+day);
        int date = 1;
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i=0; i<day%7; i++) {
            System.out.printf("\t");
        }
        for(int i=0; i<lastDay; i++,date++) {
            System.out.printf("%02d\t",date); //%d 1자리 정수 출력%2d = 2자리 정수 출력
            day++;
            if(day%7==0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        makeCalendar(2024,12);
//        LocalDate today = LocalDate.now(); //날짜를 얻을때 LocalDate
//        System.out.println(today);
//        Month month = today.getMonth();  //today.getMonth 가 영어로 나오지 않게하려면 해야하는것
//        int numOfMonth = month.getValue(); //month가 숫자로 나오게됨.
//        System.out.println(today.getYear() + "-" + today.getMonth().getValue() + "-" +
//                today.getDayOfMonth() + "  " + today.getDayOfWeek().getValue());//today.getMonth,today.getDayOfWeek는 영어로 나오니 .getValue()를 추가.
        //sun 0~ sat7


//        LocalDate xmas = LocalDate.of(2024, 12 , 25);
//        System.out.println(xmas);
//
//        LocalDate election = LocalDate.parse("2024-04-10"); //election 지정날짜로변경
//        System.out.println(election);
//
//        LocalTime currentTime = LocalTime.now();  //시간을 얻을떄 LocalTime
//        System.out.println(currentTime);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
        System.out.println( now.format(dateTimeFormatter));
    }
}
