import java.util.Scanner;

public class ContinueTest {
    public static void main(String[] args) {
        //숫자 5개를 입력받아서 양수의 합만 구하기
        // continue;건너뛰기
        // break;for문 빠져나오기
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int count = 1; count <= 5; count++) {
            int num = scanner.nextInt();
            if (num<0) {
                continue;
            }else  {
                sum += num;
            }
        }
        System.out.println("입력한 수 중에 양수의 합은 = " + sum);
    }
}
