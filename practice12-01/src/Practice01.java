import java.util.Scanner;

class CountThread implements Runnable{

    @Override
    public void run() {
        System.out.println("스레드 실행 시작");
            int num=0;
        while(true){
            num++;
            System.out.println(num);
            if(num==10){
                System.out.println("스레드 실행 종료");
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("스레드 실행 종료");
            }

        }
    }
}
public class Practice01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아무키나 입력 >>");
        sc.nextLine();
        //1~10 출력
        Thread thread = new Thread(new CountThread());
        thread.start();
    }
}
