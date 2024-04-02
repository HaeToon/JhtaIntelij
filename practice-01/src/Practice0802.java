import java.util.Arrays;
import java.util.Scanner;

public class Practice0802 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 몇개?");
        int num = scanner.nextInt();
        System.out.print(num+"개");
        int arr[] = new int[num];
        for(int i=0; i<num; i++) {
            int randomNum = (int)(Math.random()*100+1);
            //안겹치게하기위해 검토
                for (int j = 0; j < i; j++) {
                   while (arr[i] != arr[j]) {
                       break;
                   }//겹치는수가 나오면 안겹칠때까지 랜덤값 반복
                }
            arr[i]=randomNum;
        }
        System.out.println(Arrays.toString(arr));
    }
}
