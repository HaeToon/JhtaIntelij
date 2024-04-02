import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for(int i=0; i<6; i++) {
            String str = scanner.next();
            char ch = str.charAt(0);
            arrayList.add(ch);
        }
        double score =0;
        for(int i=0; i<arrayList.size(); i++) {
            char ch = arrayList.get(i);
            if(ch=='A'){
                score+=4.0;
            }else if(ch=='B') {
                score+=3.0;
            }else if(ch=='C') {
                score+=2.0;
            }else if(ch=='D') {
                score+=1.0;
            }else if(ch=='F') {
                score+=0.0;
            }
        }
        System.out.println("학점의 평균은"+score/arrayList.size());
    }
}
