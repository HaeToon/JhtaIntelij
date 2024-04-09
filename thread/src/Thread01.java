public class Thread01 extends Thread{ //thread를 상속받아 override로 run을 구현한다.
    int i=0;
    @Override
    public void run() {
        //여기에 실행코드를 넣어주면 된다.
        while(true){
            System.out.println(i);
            i++;
            try {
                sleep(60000);
            } catch (InterruptedException e) {  //run을 종료시킬때 InterruptedException try catch 해줭야함.
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.run();
    }
}
