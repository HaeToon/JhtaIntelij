package Ten;

import java.util.Calendar;
import java.util.Scanner;

public class Player {
    private String name;
Scanner scanner= new Scanner(System.in);
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int turn(){
        System.out.println(name+"님 시작 <Enter>키>>");
        String key = scanner.nextLine();
        Calendar calendar=Calendar.getInstance();
        int firstSec = calendar.get(Calendar.SECOND);
        System.out.println("현재 초 시간 = "+firstSec);
        System.out.println("10초뒤에 Enter키를 눌러주세요");
        key=scanner.nextLine();
        calendar=Calendar.getInstance();
        int endSec = calendar.get(Calendar.SECOND);
        System.out.println("현재 초 시간 = "+endSec);
        if(firstSec>endSec) {
            endSec+=60;
        }
        return endSec-firstSec;
    }
}
