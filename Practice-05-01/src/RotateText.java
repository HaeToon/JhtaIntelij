import java.util.Scanner;

public class RotateText {
    public static void main(String[] args) {
        System.out.println("문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        // i love you
        //  love youi
        // love youi
        for(int i=0; i<str.length();i++) {
            String first = str.substring(0,1); // I
            String rest = str.substring(1); // 1,str.length() love you
            str = rest+first;
            System.out.println(str);
        }
    }
}
