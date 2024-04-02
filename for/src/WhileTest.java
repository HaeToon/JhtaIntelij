import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {

        int i = 0;
        while (i < 10) {
            System.out.print(i + "\t");
            i++;
        }
        //계속 입력받아서 -1을 입력하면 while문 빠져나가기
        //1+3+4+2+5+6+7
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        int count = 0;
        // 반복문 for while do~while
        while (num != -1) {
            //연산
            count++;
            sum += num;
            num = scanner.nextInt();
        }
        System.out.println(sum);
        System.out.println("평균 = " + (double)sum / count);
    }
}
