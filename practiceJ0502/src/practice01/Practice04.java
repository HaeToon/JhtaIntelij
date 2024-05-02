package practice01;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("3개의 정수를 입력해주세요");
        int a =sc.nextInt();
        int b =sc.nextInt();
        int c =sc.nextInt();

        if(a>b && a<c || a>c && a<b) {
            System.out.println("중간값은 "+a);
        }else if(b>a && b<c || b>c && b<a) {
            System.out.println("중간값은"+b);
        }else {
            System.out.println("중간값은"+c);
        }

    }
}
