import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하면 별을 출력합니다.");
        int num = scanner.nextInt();

        //내답

//        int numCopy = num;
//        for(int i= 0; i<numCopy; i++) {
//            System.out.println();
//            for(int j =0; j<num; j++) {
//                System.out.print("*");
//            }
//            num--;
//        }

        //답

//        for(int i=0; i<num; i++) {
//            for(int j =0; j<num-i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        //12345

//        for(int i =0; i<num; i++) {
//            for(int j =0; j<=i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        //피라미드

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
