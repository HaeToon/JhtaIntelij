import java.util.Arrays;
import java.util.Scanner;
public class Practice05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("양의정수 10개를쓰시오.");
        int numArray[] = new int[10];

        //내답

//        int three[] = new int[10];
//        int j=0;
//        for(int i=0; i<10; i++) {
//            int num = scanner.nextInt();
//            numArray[i]=num;
//            if (num%3==0) {
//                three[j]=num;
//                j++;
//            }
//        }
//        System.out.println(Arrays.toString(three));

        // 답

        for(int i=0; i<10; i++) {
            numArray[i]=scanner.nextInt();
        }
        System.out.println("입력한값중 3의배수는 ===");
        for(int i=0; i<10; i++ ) {
            if(numArray[i]%3==0) {
                System.out.print(numArray[i]+"\t");
            }
        }
        System.out.println(Arrays.toString(numArray));
    }
}
