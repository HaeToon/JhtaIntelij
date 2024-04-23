package functional08;


import java.util.function.Function;
import java.util.function.Supplier;

interface MyFunctionInterface {
    MyMath method ();
}
class MyMath{
    public MyMath(){
        System.out.println("MyMath 기본생성자");
    }
    public MyMath(int num){
        System.out.println("MyMath 매개변수 하나생성자");
    }
    public void print(int num01,int num02){
        System.out.println(num01+num02);
    }
}
public class Lamda08 {
    public static void main(String[] args){
        MyFunctionInterface myFunctionInterface01 = new MyFunctionInterface() {
            @Override
            public MyMath method() {
                return new MyMath();
            }
        };
        MyFunctionInterface myFunctionInterface02 = () -> new MyMath();
        //생성자 참조
        MyFunctionInterface myFunctionInterface03 =MyMath::new;
        Function<Integer,MyMath>myMathFunction = MyMath::new;
       MyMath myMath04 = myMathFunction.apply(100);
        MyMath myMath01 = myFunctionInterface01.method();
        myMath01.print(10,20);
        MyMath myMath02 = myFunctionInterface02.method();
        myMath02.print(30,40);
        MyMath myMath03 = myFunctionInterface03.method();
        myMath03.print(50,60);
        myMath04.print(100,100);
        //java에 미리 정의되어있는 함수형interface들이 있음.
//        java.util.function.Function
//        Runnable //이것만 java.util에 없음. java.lang에있음. 매개변수가 없다
//        Supplier<T> 매개변수가 없고 리턴만 있음. 공급자
//        Consumer<T> void accept(T t) 매개변수가 있고 리턴값이 없음 소비자
//        Function<T,R> R apply(Tt)
//        Predicate<T>boolean test (T t) 매개변수있고 boolean 리턴 예측

    }
}
