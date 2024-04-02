import java.util.*;
public class StringTokenizerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(true){
            System.out.println(">>");
            String text=scanner.nextLine();
            if(text.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(text," ");
            for(int i=0; i<stringTokenizer.countTokens();i++) {
                count++;
            }
            System.out.println("음절의 개수는 "+count +"입니다.");

        }
    }
}
