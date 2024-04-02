import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Practice04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vector<Integer>rain = new Vector<Integer>();
        int sum=0;
        while(true){
            System.out.println("강수량 입력 0입력시 종료");
            int num=sc.nextInt();
            if(num==0){
                System.out.println("종료합니다.");
                break;
            }else {
                rain.add(num);
                Iterator<Integer>rainQuantity=rain.iterator();
                sum+=num;
                while(rainQuantity.hasNext()){
                    System.out.print(rainQuantity.next()+"\t");
                }
                System.out.println("현재 강수량 평균="+sum/rain.size());
            }
        }
    }
}
