import java.util.Random;

public class MathTest {
    public static void main(String[] args) {
        System.out.println(Math.abs(-9)); // abs=절대값
        System.out.println(Math.round(1.5)); // round = 반올림
        System.out.println(Math.ceil(1.5)); // ceil = 올림
        System.out.println(Math.floor(1.9)); // floor = 버림
        System.out.println(Math.sqrt(9)); // sart = 루트
        System.out.println(Math.pow(3,2)); // pow = 제곱 pow(2,10) = 2의10제곱 1024
        System.out.println(Math.PI); // PI 3.14~
        System.out.println(Math.max(10,2)); // max(10,2) 둘중 큰수
        System.out.println(Math.min(10,2)); // max(10,2) 둘중 작은수
        System.out.println(Math.random()); // 0~1사이의 수
        Random random = new Random();  // 랜덤 유틸
        random.nextInt(45);     // 0~44의수 랜덤으로 나옴.
        for(int i=0; i<6; i++){
            System.out.print( random.nextInt(45)+1+",");
        }

        //ceil 사용 = 123개의 게시물를 10개씩 페이지로 나누겠다 >
        //(123/10).ceil = 13
        //  1 | 2 | 3 | 4 | 5 >>}
    }
}
