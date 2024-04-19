package practice01;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = {50000,10000,5000,1000,500,100,50,10};
        System.out.println("변환할 원화를 입력해주세요,");
        int won=sc.nextInt();
        for(int i=0; i<arr.length;i++){
            int rest = won/arr[i];
            System.out.println(arr[i]+"원"+rest+"개");
            won=won%arr[i];
        }
    }
}
