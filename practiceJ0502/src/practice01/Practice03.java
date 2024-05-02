package practice01;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int won[] = {50000,10000,5000,1000,500,100,50,10};
        int money = sc.nextInt();
        int rest =0;
        for(int i=0; i<won.length; i++){
            rest=money/won[i];
            System.out.println(won[i]+"원"+rest+"개");
            money=money%won[i];
        }
    }
}
