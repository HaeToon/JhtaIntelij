import java.util.Scanner;
public class GambleTest {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int turn=0;
        int randomNum[] = new int[3];
        System.out.println("1번째 선수 이름 >>");
        String firstName = scanner.next();
        System.out.println("2번째 선수 이름 >>");
        String secondName = scanner.next();
        while(true) {
            if(turn==0){
                System.out.println("["+firstName+"]");
                System.out.println("<Enter>");
                String hand = scanner.next();
                if(hand.equals(null)){
                    for(int i=0; i<3; i++) {

                        System.out.print(i+"번째 숫자 ="+);
                    }
                }

            }

        }
    }
}
