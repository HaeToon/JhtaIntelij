package practice01;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("원화를 입력하세요");
        int won = sc.nextInt();
        System.out.println(won+"원은"+won/1300+"$입니다.");
    }
}
