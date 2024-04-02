import java.util.Scanner;
public class MonthSchedule {
    Scanner scanner = new Scanner(System.in);
    Day day[]= new Day[30];
    int input;
int date;
    MonthSchedule(int date){
        this.date=date;
    }

    void run() {
        while(true){
            System.out.println("이번달 스케줄 관리 프로그램");
            System.out.println("할일(입력:1, 보기:2, 끝내기:3) >>");
            input = scanner.nextInt();
            switch(input) {
                case 1:
                    System.out.println("날짜(1~30)?");
                    input = scanner.nextInt();
                    System.out.println("할일(빈칸없이입력)?");

                    break;
                case 2:

                    break;

                case 3:

                    break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}

