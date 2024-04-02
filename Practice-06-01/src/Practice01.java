import java.util.Scanner;
import java.util.Vector;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer>vector = new Vector<Integer>();
        while(true){
            System.out.println("정수(-1입력시 종료)를 입력해 주세요.");
            int num = scanner.nextInt();
            if(num<0) {
                break;
            }else {
                vector.add(num);
            }
        }
        int big=vector.get(0);
        for(int i=0; i<vector.size(); i++) {
            if(vector.get(i)>big){
                big=vector.get(i);
            }
        }
        System.out.println("제일큰 숫자는 "+big);
    }
}
