package functional02;

@FunctionalInterface
interface MyfunctionInterface {
    void method02(int num);
}

public class Lamda02 {
    public static void main(String[] args) {
//        MyfunctionInterface myfunctionInterface = new MyfunctionInterface() {
//            @Override
//            public void method02(int num) {
//
//            }
//        };
        //호출할 메서드가 하나라서 여러가지 생략가능.
        MyfunctionInterface myfunctionInterface01 = (int num) -> System.out.println("매개변수 num : " + num);
        //호출할 메서드가 하나이고 그 메서드에 타입등이 있기때문에 타입추론으로 타입생략가능.
        MyfunctionInterface myfunctionInterface02 = (num) -> System.out.println("매개변수 num : " + num);
        myfunctionInterface01.method02(10);
        myfunctionInterface02.method02(20);
        //람다식은 Stream과 많이쓰인다.
        //계속 쓰면서 람다식에 익숙해져야한다.
    }
}
