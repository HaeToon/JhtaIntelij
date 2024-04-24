//공유자원
class ShareBoard {
    //context switching 서로 왔다갔다 함.
    private int sum = 0;

   synchronized void add() { //symchronized 동기화하기 순서를 기다림.
        int num = sum;
        num += 10;
        sum = num;
        System.out.println(Thread.currentThread().getName() + " : " + sum);
    }

    public int getSum() {
        return sum;
    }
}
//
class StudentThread extends Thread {
    private ShareBoard shareBoard;

    public StudentThread(ShareBoard shareBoard, String name) {
        super(name); //부모생성자 호출
        this.shareBoard = shareBoard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shareBoard.add();
        }
    }
}

public class ThreadSync {
    public static void main(String[] args) {
        ShareBoard shareBoard = new ShareBoard();
        StudentThread studentThread01 = new StudentThread(shareBoard, "태훈");
        StudentThread studentThread02 = new StudentThread(shareBoard, "우연");
        studentThread01.start();
        studentThread02.start();
    }
}
