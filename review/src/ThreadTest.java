class TimerThread extends Thread{
    int num = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(num);
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class TimerThread02 implements Runnable {
    int num = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(num);
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public TimerThread02() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
public class ThreadTest {
    public static void main(String[] args) {
//        TimerThread timerThread =new TimerThread();
//       timerThread.start();
//        Thread thread = new Thread(new TimerThread02());
//        thread.start();
         new TimerThread02(); //생성자에 Thread구현

    }
}
