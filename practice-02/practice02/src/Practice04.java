import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        System.out.println("소문자 알파벳 하나를 입력하세요 >>>");
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        char ch = first.charAt(0);

        //내답

//        char chCopy=ch;
////        System.out.println(ch - 96);
//        for(int j=96; j<chCopy; j++) {
//            System.out.println();
//            for (int i = 96; i <= ch; i++) {
//                System.out.print((char)i);
//            }
//            ch--;
//        }

        //답

        for(char i=ch; i>='a'; i--) {
            for (char j='a';j<=i;j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
