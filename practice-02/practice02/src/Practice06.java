import java.util.Scanner;

public class Practice06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int money = scanner.nextInt();
        System.out.println("금액을 입력하시오");

        for (int i = 0; i < unit.length; i++) {
            int rest = money / unit[i];
            System.out.println(unit[i]+"원" + rest + "장");
            money = money % unit[i];
        }
    }
}
