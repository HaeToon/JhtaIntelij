import java.util.Arrays;
import java.util.Scanner;

public class StringStackTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("총 스택 저장 공간의 크기 입력 >>>");
        int total = scanner.nextInt();
        StringStack stringStack = new StringStack(total);

        while (true) {
            System.out.println("문자열 입력");
            String str = scanner.next();
            boolean over = stringStack.push(str);
            if (str.equals("그만")) {
                break;
            }
            if (over == false) {
                System.out.println("스택이 꽉차서 푸시 불가!");
            }
        }
        int end = stringStack.length();
        System.out.println("end==="+end);
        for(int i=0; i<end;i++) {
            System.out.print(stringStack.pop());
        }

    }
}
