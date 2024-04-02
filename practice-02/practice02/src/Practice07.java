import java.util.Arrays;

public class Practice07 {
    public static void main(String[] args) {
        int arr[] = new int[10];

        for(int i=0; i<arr.length; i++){
            int num = (int)(Math.random()*10+1);
            arr[i]=num;
        }
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println((double)sum/arr.length);
    }
}
