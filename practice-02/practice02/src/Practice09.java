import java.util.Scanner;
public class Practice09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Hand[] = {"가위","바위","보"};
        System.out.println("가위 바위 보중 하나를 내주세요 그만을 입력하면 종료합니다.");

        while(true) {
            System.out.println("가위, 바위, 보 게임을 시작합니다.");
            String myHand = scanner.next();
            if(myHand.equals("그만")) {
                System.out.println("가위 바위 보를 종료합니다.");
                break;
            }
            int ran = (int)(Math.random()*3); // Math.random()*3을 묶어줘야함.
            String comHand = Hand[ran];
            System.out.printf("내가 낸 것 = %s , 컴퓨터가 낸것 = %s",myHand,comHand);
            if(myHand.equals(comHand)) {
                System.out.println();
                System.out.println("비겼습니다.");
            } else if (myHand.equals("가위") && comHand.equals("보") ||
                       myHand.equals("바위") && comHand.equals("가위") ||
                       myHand.equals("보") && comHand.equals("바위") )     {
                System.out.println();
                System.out.println("플레이어가 이겼습니다.");
            } else {
                System.out.println();
                System.out.println("컴퓨터가 이겼습니다.");
            }
        }
    }
}
