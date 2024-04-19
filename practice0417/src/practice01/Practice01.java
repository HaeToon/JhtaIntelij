package practice01;
import java.util.Scanner;
public class Practice01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("달러로 변환할 원화를 입력해 주세요");
        int won=sc.nextInt();
        System.out.println(won+"원은"+won/1300+"달러입니다.");
    }
}
