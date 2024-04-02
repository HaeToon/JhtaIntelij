import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        //세개의 정수를 입력받아 합계를 구하시오
        //이떄 정수가 아닌 값을 예외처리하시오
        Scanner scanner = new Scanner(System.in);
        System.out.println("세개의 정수를 입력해 주세요");
//        while (true) {
//            System.out.println("세개의 정수를 입력해 주세요");
//            try {
//                int num01 = scanner.nextInt();
//                int num02 = scanner.nextInt();
//                int num03 = scanner.nextInt();
//                System.out.printf("%d, %d, %d, 의 합계는 %d 입니다.", num01, num02, num03, num01 + num02 + num03);
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("잘못 입력하셨습니다.");
//                scanner.next();
//            } finally {
//
//            }
        int sum=0,num=0;
        for(int i=1; i<=3;i++) {
            System.out.println(i + "번째 숫자를 입력해주세요.");
            try {
                num = scanner.nextInt();
            }catch(InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 정수를 입력해 주세요");
                scanner.next();
                i--;
                continue;
            }finally {

            }
            sum+=num;
        }
        System.out.println(sum);
    }
}
