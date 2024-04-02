import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num01, num02;
        while (true) {

            try {
                //예외가 발생할 수 있는 실행문 num02 ==0일때 오류 발생
                System.out.println("숫자를 입력하세요");
                num01 = scanner.nextInt();
                System.out.println("나눌 수를 입력하세요");
                num02 = scanner.nextInt();
                System.out.printf("%d를 %d로 나누면 %d입니다.", num01, num02, num01 / num02);
                break;
            } catch (ArithmeticException e) {
                //오류발생시 예외를 어떻게 처리할건지
                System.out.println("0으로 나눌수 없습니다.");
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요.");
                scanner.next();
            } finally {
                System.out.println("나는 무조건 실행");
            }
        }
    }
}
