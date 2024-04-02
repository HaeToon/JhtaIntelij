import java.util.Arrays;
import java.util.Scanner;
public class Practice08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 몇개?");
        int num = scanner.nextInt();
        System.out.print(num+"개");
        int arr[] = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = (int)(Math.random()*100+1);
                for (int j = 0; j < i; j++) {
                    if(arr[i]==arr[j]) {
                        i--;
                    }
                }
//            arr[i]=randomNum;
        }
        System.out.println(Arrays.toString(arr));
    }
}
