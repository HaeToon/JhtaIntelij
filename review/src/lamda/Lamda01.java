package lamda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface //method를 하나만 쓰게 만드는것.
interface MyFunctionalInterface {
    void method01();
}

@FunctionalInterface //method를 하나만 쓰게 만드는것.
interface MyFunctionalInterface02 {
    void method01(int num);
}

@FunctionalInterface //method를 하나만 쓰게 만드는것.
interface MyFunctionalInterface03 {
    void method01(int num01, int num02);
}

@FunctionalInterface //method를 하나만 쓰게 만드는것.
interface MyFunctionalInterface04 {
    int method01(int num);
    //제곱구하기
}

public class Lamda01 {
    public static void main(String[] args) {
        // -> 간단히 쓰기
        //lamda expression 식 값이 있으면 식
        MyFunctionalInterface myFunctionalInterface01 = new MyFunctionalInterface() {
            @Override
            public void method01() {
                System.out.println("람쥐썬더식01 ");
            }
        };
        MyFunctionalInterface myFunctionalInterface02 = () -> System.out.println("람쥐썬더식02 ");
        myFunctionalInterface01.method01();
        myFunctionalInterface02.method01();

        MyFunctionalInterface02 myFunctionalInterface0201 = new MyFunctionalInterface02() {
            @Override
            public void method01(int num) {
                System.out.println("num : " + num);
            }
        };
        myFunctionalInterface0201.method01(5);
        MyFunctionalInterface02 myFunctionalInterface0202 = num -> System.out.println("num : " + num);
        myFunctionalInterface0202.method01(10);

        MyFunctionalInterface03 myFunctionalInterface0301 = new MyFunctionalInterface03() {
            @Override
            public void method01(int num01, int num02) {
                System.out.println("num01 : " + num01 + " num02 : " + num02);
            }
        };
        myFunctionalInterface0301.method01(5, 6);
        MyFunctionalInterface03 myFunctionalInterface0302 = (num01, num02) -> System.out.println("num01 : " + num01 + " num02 : " + num02);
        myFunctionalInterface0302.method01(7, 8);

        MyFunctionalInterface04 myFunctionalInterface0401 = new MyFunctionalInterface04() {
            @Override
            public int method01(int num) {
                return num * num;
            }
        };
        System.out.println(myFunctionalInterface0401.method01(5));
        MyFunctionalInterface04 myFunctionalInterface0402 = num -> num * num;
        System.out.println(myFunctionalInterface0402.method01(5));

        List<String> list = Arrays.asList("apple", "orange", "peach", "banana", "berry", "cherry");
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        /* 함수명은 람다식으로 지우기때문에 큰의미는없다.
        1. 매개변수가 없고 return 이 없고    Runnable<T>
        2. 매개변수가 없고 return 이 있고    Supplier<T> get()
        3. 매개변수가 있고 return 이 없고    Consumer<T>accept(T t)
        4. 매개변수가 하나 return 이 있고    Function<T,R> R apply(T t)
        5. 매개변수가 있고 리턴 이 boolean Predicate<t>boolean accept(T t)
         */
        Predicate<String> isEmptyString = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()==0;
            }
        };
        String msg ="awadawf";
        Predicate<String> isEmptyString02 =  s -> s.length()==0;
            if(!isEmptyString02.test(msg)){
                System.out.println("문자열이 공백이 아니무니다");
            }


    }
}
