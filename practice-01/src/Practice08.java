import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args) {
        System.out.println("연산할 것을 입력하시오. >>");
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt(); // 연산할 첫번째 숫자
        String operator = scanner.next(); // 연산할 부호
        int second = scanner.nextInt(); //연산할 두번째 숫자
        int result = 0;
        if(operator.equals("+")) {
            result = first+second;
        } else if (operator.equals("-")) {
            result = first - second;
        } else if (operator.equals("*")) {
            result = first * second;
        } else if (operator.equals("/")) {
            result = first / second;
        }
        System.out.printf("%d %s %d 연산결과는 %d" , first,operator,second,result);
    }
}
