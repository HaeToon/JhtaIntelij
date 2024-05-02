package practice01;

import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("연산할 두정수와 연산자를 입력해 주세요");
        int a = sc.nextInt();
        int b = sc.nextInt();
        String operation = sc.next();

        if(operation.equals("+")){
            System.out.println(a+b);
        }else if(operation.equals("-")){
            System.out.println(a-b);
        }else if(operation.equals("*")){
            System.out.println(a*b);
        }else if(operation.equals("/")){
            if(b!=0){
                System.out.println(a/b);
            }else if (b==0){
                System.out.println("0으로 나눌수 없습니다.");
            }
        }else {
            System.out.println("잘못입력했습니다.");
        }
    }
}
