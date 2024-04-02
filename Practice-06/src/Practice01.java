import java.util.Scanner;
import java.util.Vector;

public class Practice01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vector<Integer>arr = new Vector<Integer>();
        int big=0;
        while(true){
            System.out.println("정수(-1이 입력될대까지)>>");
            int num=sc.nextInt();

            if(num<0) {
                System.out.println("그만");
                System.out.println("가장 큰 수는 =="+big);
                break;
            }else {
                arr.add(num);
                if(big<num){
                    big=num;
                }
            }
        }
    }
}
