import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SplitTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }
            //글자 > 단어 > 줄 >enter 단락
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            System.out.println("단어의 갯수는 " + stringTokenizer.countTokens());
            while (stringTokenizer.hasMoreTokens()) {//hasMoreTokens다음 단어가 있는지 없는지 확인
                System.out.print(stringTokenizer.nextToken()+" ");
            }
           String strArr[]=str.split(" ");
            System.out.println(strArr.length);
            System.out.println(Arrays.toString(strArr));

        }
    }
}
