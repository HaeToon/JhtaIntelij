package functional04;
@FunctionalInterface
interface MyfunctionInterface{
    void method04 (); //void 앞의 public abstract는 생략되어있음.
}
class MyMath{
    public void print(){
        System.out.println("print () 메서드를 호출합니다.");
    }
}
public class Lamda04 {
    public static void main(String[] args){
        MyfunctionInterface myfunctionInterface01 = new MyfunctionInterface() {
            @Override
            public void method04() {
                MyMath myMath = new MyMath();
                myMath.print();
            }
        };
        MyfunctionInterface myfunctionInterface02 =() -> {
            MyMath myMath = new MyMath();
            myMath.print();
        };
        myfunctionInterface01.method04();
        myfunctionInterface02.method04();
        //메서드 호출 하나의 메서드만 호출할때 줄여쓰는 방법
        MyMath myMath = new MyMath();
        MyfunctionInterface myfunctionInterface03 =myMath::print;

        myfunctionInterface03.method04();
    }
}
