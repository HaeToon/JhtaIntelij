import java.util.Scanner;
public class MonthSchedule {
    private Day dayList[]; //전역변수
   private Scanner scanner = null;


    MonthSchedule(int num) { //기본생성자 중괄호 안에 변수를 만들면 지역변수가됨. 지역변수는 {중괄호}안에서만 쓰여짐.
        dayList=new Day[num];
        scanner = new Scanner(System.in);
        for(int i=0; i<num; i++) {
            dayList[i]= new Day();
        }
    }

    public void input() {
        System.out.println("날짜를 입력해주세요(1~30)");
        int day = scanner.nextInt();
        day --; //배열은 0번부터 시작하기때문에 1을 빼야함.
        System.out.println("해야할 일을 빈칸없이 입력해주세요. Enter키는 동작하지 않습니다. ");
        String work = scanner.next();
        dayList[day].set(work);
   };
    public void view() {
        System.out.println("해야할일을 보여줍니다.");
        System.out.println("날짜를 입력해 주세요 (1~30)");
        int day=scanner.nextInt();
        day--;      //배열은 0번부터 시작하기때문에 1을 빼야함.
        System.out.print(day+1 + "일에 할 일은");
        dayList[day].show();
    };
    public void finish() {
        System.out.println("스케쥴 관리 프로그램을 종료합니다.");
    };
    public void run() {
        while(true) {
            System.out.println("todo list(입력:1, 보기:2, 종료:3) >>");
            int menu = scanner.nextInt();
            ;if(menu==1) {
                input();
            } else if (menu==2) {
                view();
            } else {
                finish();
                break;
            }
        }
    };
}
