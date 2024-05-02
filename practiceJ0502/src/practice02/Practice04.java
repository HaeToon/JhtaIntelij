package practice02;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("소문자알파벳 하나를 입력하세요");
        String str = sc.next();

        char ch = str.charAt(0);

        for(char i =ch; i>='a'; i--){
            for(char j ='a'; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
