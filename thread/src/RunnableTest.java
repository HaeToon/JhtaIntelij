public class RunnableTest implements Runnable{

    @Override
    public void run() {
            int num =0;
        while(true){
            num++;
            System.out.println(num);
//            sleep(1000);//Thread를 상속받지않아서  사용불가 import로도 가능.

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
       Thread thread = new Thread(new RunnableTest());
       thread.start();
    }
}
