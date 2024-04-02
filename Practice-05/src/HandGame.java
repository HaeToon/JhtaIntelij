import java.util.Scanner;
public class HandGame {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String hand = ",가위(1),바위(2),보(3)";
        String handList[] =hand.split(",");
        System.out.println(handList[0]);
        System.out.println(handList[1]);
        System.out.println(handList[2]);
        while(true) {
            System.out.println("[가위(1), 바위(2), 보(3), 끝내기(4)]");
            int myHand = scanner.nextInt();
            int comHand=(int)(Math.random()*3+1);
            if(myHand==4) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            System.out.println("플레이어 "+handList[myHand]);
            System.out.println("컴퓨터 "+handList[comHand]);
            if(myHand==comHand) {
                System.out.println("무승부 입니다.");
            }else if (myHand==1 && comHand == 3 ||
            myHand == 2 && comHand==1 ||
            myHand==3 && comHand==2){
                System.out.println("플레이어가 이겼습니다.");
            }else {
                System.out.println("컴퓨터가 이겼습니다.");
            }
        }

    }
}
