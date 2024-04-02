import java.util.Scanner;

public class BreakTest {
    public static void main(String[] args) {
        System.out.println("exit를 쓰면 빠져나갑니다.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(">>>");
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                break;
            }
        }
        System.out.println("종료합니다.");
    }
}
