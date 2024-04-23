package functional07;

@FunctionalInterface
interface MyFunctionInterface {
    void method(MyMath myMath, int num01, int num02);
}

class MyMath {
    public void print(int num01, int num02) {
        System.out.println(num01 + num02);
    }
}

public class Lamda07 {
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface01 = new MyFunctionInterface() {
            @Override
            public void method(MyMath myMath, int num01, int num02) {
                myMath.print(num01, num02);
            }
        };
        //위와같음.
        MyFunctionInterface myFunctionInterface02 = (myMath, num01, num02) -> myMath.print(num01, num02);
        myFunctionInterface01.method(new MyMath(), 10, 20);
        myFunctionInterface02.method(new MyMath(), 100, 200);
        MyFunctionInterface myFunctionInterface03 = MyMath::print;
        myFunctionInterface03.method(new MyMath(), 1000, 2000);

    }
}
