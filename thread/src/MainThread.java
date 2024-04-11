public class MainThread {
    public static void main(String[] args) {
        //main도 Thread이다.
        String mainThread = Thread.currentThread().getName();
        long id = Thread.currentThread().threadId();
        System.out.println(mainThread);
        System.out.println(id);
        Thread.State state =Thread.currentThread().getState();
        System.out.println(state);

//        Thread 동기화
//        Thread가 혼자 동작중일때는 상관없음
        //print =1개 5명이print(thread)
        //순서만들기


    }
}
