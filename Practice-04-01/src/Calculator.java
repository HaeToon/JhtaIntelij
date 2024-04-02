import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = null;
        System.out.println("정수 두개와 연산자를 입력해 주세요");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();
        if (operator.equals("+")) {
            calc = new Add();
        } else if (operator.equals("-")) {
            calc = new Sub();
        } else if (operator.equals("*")) {
            calc = new Mul();
        } else if (operator.equals("/")) {
            calc = new Div();
        }
        calc.setValue(a, b);
        int result = calc.calculate();
        System.out.println(result);
    }
}
