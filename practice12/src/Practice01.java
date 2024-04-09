import java.util.Scanner;

public class Practice01 extends Thread{
    private int i=0;
    @Override
    public void run() {
        System.out.println("스레드 실행 시작");
        while(true){
            i++;
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("스레드 실행 종료");
            }
            if(i==10){
                System.out.println("스레드 실행 종료");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Practice01 thread = new Practice01();
        Scanner sc = new Scanner(System.in);
        System.out.println("아무거나입력 >>");
        sc.next();
        thread.run();
    }
}
