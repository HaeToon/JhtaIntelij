import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) throws ParseException {
//        LocalDate
//        LocalDateTime
//        Calendar today = new Calendar() {} // Calendar는 abstract기 때문에 생성자함수를 쓰지못한다.
   Calendar today = Calendar.getInstance();
   int year =today.get(Calendar.YEAR);
   int month =today.get(Calendar.MONTH);
   int date =today.get(Calendar.DATE);
   int hour = today.get(Calendar.HOUR);
   int hour24 = today.get(Calendar.HOUR_OF_DAY);
   int min = today.get(Calendar.MINUTE);
   int sec = today.get(Calendar.SECOND);
        System.out.println(year+"년"+(month+1)+"월"+date+"일"+hour +"시"+min+"분"+sec+"초");
        System.out.println(year+"년"+(month+1)+"월"+date+"일"+hour24 +"시"+min+"분"+sec+"초");
        int era = today.get((Calendar.ERA)); // 1 : ad 0: bc
        System.out.println(era);
        int apm = today.get(Calendar.AM_PM);
        System.out.println(apm==1?"pm":"am"); //1 = 오후 pm 0= 오전 am
        int dayOfYear = today.get(Calendar.DAY_OF_YEAR);  // 이번년도에 지난 일수
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH); // 이번달에 지난 일수
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);  //요일 sun=1 mon=2 tue=3 ...
        System.out.println(dayOfYear+"==="+dayOfMonth+"==="+dayOfWeek);

//        2023:03:27
//        2023-03-27

        today.set(2024,2,27);
        Date now = today.getTime();  //Calendar 를 Date로 바꿔서 넣어야 한다. simpleDateFormat 으로 원하는 형식으로 바꿀수있음.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd/"); //많이씀
        String str =simpleDateFormat.format(now);
        System.out.println(str);

      DateFormat dateFormat = new SimpleDateFormat("MM.dd. YYYY");
        String frontDate = "2024년 3월 27일";      //문자열로 들어온것을 데이터로 바꿀때는 parse해야함.
      //예외처리 해야함.
        dateFormat.parse(frontDate);
        try {
            Date now02 = dateFormat.parse(frontDate);
            System.out.println(simpleDateFormat.format((now02)));

        }catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
