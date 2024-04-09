import java.util.Scanner;

public class Practice0102 implements Runnable{
    private int i=0;
    Thread thread;

    @Override
    public void run() {
        System.out.println("스레드 실행 시작");

        while(true){
            i++;
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                System.out.println("스레드 실행 종료");
            }
            if(i==10){
                System.out.println("스레드 실행 종료");
                return;
//                thread.interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Practice0102());
        Scanner sc = new Scanner(System.in);
        System.out.println("아무거나입력 >>");
        sc.next();
        thread.start();
    }
}
