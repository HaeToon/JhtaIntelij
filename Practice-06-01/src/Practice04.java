import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> vector = new Vector<Integer>();

        while(true){
            System.out.println("강수량을 입력해 주세요(0입력시종료).");
            int num = scanner.nextInt();
            if(num==0) {
                break;
            }else {
                vector.add(num);
                Iterator<Integer>iterator = vector.iterator();
                int sum=0;
                while(iterator.hasNext()){
                    int num02=iterator.next();
                    System.out.print(num02 +"\t");
                    sum+=num02;
                }
                System.out.println();
                System.out.println("현재까지의 강수량 평균은"+sum/vector.size());
            }
        }
    }
}
