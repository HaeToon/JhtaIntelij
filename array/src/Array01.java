import java.util.ArrayList;
import java.util.Scanner;
public class Array01 {
    public static void main(String[] args) {
//        primitive 기본타입 reference
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10]; // 배열은 반드시 생성후 타입 선언 new  10개짜리 배열
        // int [] arr = new int [10]; 위와 같은내용  arr의 앞이나 뒤에 [] 아무곳이나 상관없음.
        // int arr02[] = {1,2,3,4,5,6,7,8,9,10}; 배열을 만들면서 {}안에 초기값 세팅
        int intArray[] = new int[5];
        int copyArray[] = intArray;
        intArray[0] = 10; //copyArray의[0]을 찍어봐도 intArray[0]의 값이 같음. 주소값이 같음
        System.out.println(copyArray[0]);
        //static  =static 영역에 미리 메모리에 올라가있는것 은 따로 생성하지않아도됨

//        자바 안에는 엄청 많은 객체가 있음
        Math.abs(-10);
//        arr[0] = 1;
//        arr[1] = 1;
//        arr[2] = 2;
//        arr[3] = 3;
//        arr[4] = 4;
//        arr[5] = 5;
//        arr[6] = 6;
//        arr[7] = 7;
//        arr[8] = 8;
//        arr[9] = 9;
        for (int i = 0; i<10; i++) {
            arr[i] = i+1;
        }
        for(int i = 0; i<10; i++) {
            System.out.println(arr[i]); //util 함수 있음  System.out.println(Arrays.toString(arr)
        }
    }
}
