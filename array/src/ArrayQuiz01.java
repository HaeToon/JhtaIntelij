import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz01 {
    public static void main(String[] args) {
        //5개의 숫자를 입력받아 배열을 만든다
        //이때 가장 큰 숫자 출력해보기
        Scanner scanner = new Scanner(System.in);
        int numArray[] = new int[5];
        int total = numArray.length;
        System.out.println("total === " + total);
        int max = 0;
        for (int i = 0; i < total; i++) {
            int num = scanner.nextInt();
            numArray[i] = num;
            if (numArray[i] > max) {
                max = numArray[i];
            }
        }
        System.out.println(Arrays.toString(numArray) + "중 가장 큰수는 " + max);
        //솔팅후 맨뒤의것 빼와도 됨
    }
}