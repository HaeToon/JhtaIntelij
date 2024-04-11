
    class Board{
        private int sum=0;
        //synchronized로 인해 임계영역으로 설저된후 rock이 걸림.
        //다른 스레드 접근 불가.
       synchronized public void add(){
            int num = sum;
            Thread.yield();
            num+=1;
            sum=num;
            System.out.println(Thread.currentThread().getName() +"=="+sum);
        }
    }
    //임계영역
    class StudentThreade extends Thread {
        private Board board;
        public StudentThreade(String name, Board board) {
            super(name); //thread의 이름 지어주기
            this.board = board;

        }
        //wait
        @Override
        public void run() {
            for(int i=0; i<5; i++){
            board.add(); // 10~100 값이200이나오는지 확인

            }
        }
    }



    public class ThreadSync {
        //칠판하나를 공유해서씀=
    public static void main(String[] args) {
        Board board = new Board();



        StudentThreade studentThreade01 = new StudentThreade("허태훈",board);
        StudentThreade studentThreade02 = new StudentThreade("최우연",board);
        studentThreade01.start();
        studentThreade02.start();
    }
}
