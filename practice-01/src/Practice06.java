import java.util.Scanner;

public class Practice06 {
    public static void main(String[] args) {
        // app 설명서 나눠주고
        System.out.println("1~99사이의 숫자를 입력하시오. >>");
        // 컴파일 오류는 쉽게 잡힌다.
        // 런타임 오류는 예외처리를 해야 한다.
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int first, second;
        int count = 0;
        first = num / 10; //앞자리 숫자
        second = num % 10; //뒷자리 숫자
        System.out.println("first==" + first +", second=="+second);
        System.out.printf("first==%d,second==%d",first,second); //위와 같음

        if (first!=0 && first % 3 == 0) {
            count++;
        }
        if (second!=0 && second % 3 == 0) {
            count++;
        }
        if (count == 1) {
            System.out.println("박수짝");
        } else if (count == 2) {
            System.out.println("박수짝짝");
        }
        //3 박수짝,6 박수짝 9 13 16 19 66 짝짝
    }
}
