import java.time.LocalDate;

public class MakeCalendar {


    public static void MakeCalendar(int year,int month) {
        LocalDate localDate = LocalDate.of(year,month,1);
        int lastDay = localDate.lengthOfMonth();
        int day = localDate.getDayOfWeek().getValue();
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i=0; i<day%7; i++) {
            System.out.print("\t");
        }
        for(int i=1; i<lastDay; i++) {
            System.out.printf("%02d\t",i);
            day++;
            if(day%7==0){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MakeCalendar(2024,3);
    }
}
