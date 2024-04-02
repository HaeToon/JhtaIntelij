import java.util.Scanner;
import java.util.StringTokenizer;

public class TurnText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요 빈칸이 있어도 되고 영어 한글 모두 됩니다.");
        String text = scanner.nextLine();
        String textList[] = text.split("");
        for(int i=0; i<text.length(); i++) {
            for(int j=0; j<text.length(); j++) {
                System.out.print(textList[j]);
            }
            for(int k=0; k<text.length()-1; k++) {
                textList[k]=textList[k+1];
            }
            textList[text.length()-1]=textList[0];
            System.out.println();
        }
    }
}
