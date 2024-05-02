package practice02;

import java.util.Scanner;

public class Practice06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int []unit={50000, 10000, 5000,1000,500,100,50,10};

        System.out.println("원 입력");
        int won = sc.nextInt();
        int rest =0;
        for(int i=0; i<unit.length; i++){
            rest=won/unit[i];
            System.out.println(unit[i]+"원"+rest+"개");
            won=won%unit[i];
        }
    }
}
