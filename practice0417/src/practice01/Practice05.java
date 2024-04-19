package practice01;

import java.util.Scanner;

public class Practice05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("삼각형의 세 변이될 정수 3개를 입력해주세요.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a+b<=c ||
        b+c<=a ||
        c+a<=b){
            System.out.println("삼각형이 될수 없습니다.");
        }else {
            System.out.println("삼각형이 될수있습니다.");
        }
    }
}
