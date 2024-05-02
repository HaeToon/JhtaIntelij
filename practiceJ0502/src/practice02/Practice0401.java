package practice02;

import java.util.Scanner;

public class Practice0401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = str.charAt(0);
        for(char i='a'; i<=ch; i++){
            for(char j='a'; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
