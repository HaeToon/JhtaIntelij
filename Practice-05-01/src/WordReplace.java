import java.util.Scanner;
import java.util.StringTokenizer;

public class WordReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>");
        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer((str));
        while(true) {
            System.out.println("명령 :");
            String command = scanner.nextLine();
            if(command.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }
                String word[] = command.split("!");
                if(word[1].equals(null)){
                    System.out.println("잘못된 명령입니다.");
                } else {
                    int start = stringBuffer.indexOf(word[0]);
                    stringBuffer.replace(start, start + word[0].length(), word[1]);
                    System.out.println(stringBuffer.toString());
                }
        }
    }
}
