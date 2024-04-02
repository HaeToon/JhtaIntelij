import java.util.Scanner;
public class ArrayPractice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
    for(int j=0;j<5; j++) {
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        num--;
        System.out.println();
    }
    }
}
