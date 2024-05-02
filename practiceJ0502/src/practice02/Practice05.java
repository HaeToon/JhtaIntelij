package practice02;
import java.util.Scanner;

public class Practice05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[]=new int[10];
        for(int i=0; i<10; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]%3==0){
                System.out.println(arr[i]);
            }
        }
    }
}
