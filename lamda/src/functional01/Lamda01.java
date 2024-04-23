package functional01;

@FunctionalInterface //functionalinterface를 사용시 method를하나 구현해야함.
interface MyfunctionInterface{
    //매개변수가 없는 람다식
    public void method01();
}
public class Lamda01 {
    public static void main(String[] args){
        MyfunctionInterface myfunctionInterface01 = new MyfunctionInterface() {
            @Override
            public void method01() {
                System.out.println("MyfunctionInterface에서 method 01을 호출");
            }
        };
        MyfunctionInterface myfunctionInterface02 = ()->{ //위의 식을 람다식으로 간단히만듬.
            System.out.println("MyfunctionInterface에서 method 01을 호출");
        };
        //한줄이기때문에 중괄호 생략 {}
        MyfunctionInterface myfunctionInterface03 = ()->System.out.println("MyfunctionInterface에서 method 01을 호출");

        myfunctionInterface01.method01();
        myfunctionInterface02.method01();
        myfunctionInterface03.method01();
    }
}
