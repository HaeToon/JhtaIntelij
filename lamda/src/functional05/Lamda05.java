package functional05;

@FunctionalInterface
interface MyfunctionInterface {
    void methodCall(int num); //void 앞의 public abstract는 생략되어있음.
}

class MyMath {
    public void print(int num) {
        System.out.println(num);
    }
}

public class Lamda05 {
    public static void main(String[] args) {
        MyfunctionInterface myfunctionInterface01 = new MyfunctionInterface() {
            @Override
            public void methodCall(int num) {
                MyMath myMath = new MyMath();
                myMath.print(num);
            }
        };
        MyfunctionInterface myfunctionInterface02 = (int num) -> {
            MyMath myMath = new MyMath();
            myMath.print(num);
        };
        //MyMath를 바깥에 선언후
//        MyMath myMath = new MyMath();
        MyfunctionInterface myfunctionInterface03 = System.out::println;
        //ClassName::메서드이름
        //instanceName::메서드 네임

        myfunctionInterface01.methodCall(10);
        myfunctionInterface02.methodCall(20);
        myfunctionInterface03.methodCall(30);


    }
}
