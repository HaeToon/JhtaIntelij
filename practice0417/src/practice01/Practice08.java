package practice01;

import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수와 연산자를 입력해주세요.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        String operater = sc.next();
        if(operater.equals("+")){
            System.out.println(a+b);
        }else if(operater.equals("-")){
            System.out.println(a-b);
        }else if(operater.equals("*")){
            System.out.println(a*b);
        }else if(operater.equals("/")){
            if(b==0){
                System.out.println("0으로나눌수없습니다.");
            }
            System.out.println(a/b);
        }else {
            System.out.println("잘못입력하셨습니다.");
        }

    }
}
