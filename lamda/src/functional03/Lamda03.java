package functional03;

interface MyfunctionInterface{
    int method03 (int num01 , int num02); //void 앞의 public abstract는 생략되어있음.
}
public class Lamda03 {
    public static void main(String[] args){
//        MyfunctionInterface myfunctionInterface01 = new MyfunctionInterface() {
//            @Override
//            public void method03(int num01, int num02) {
//
//            }
//        };
        MyfunctionInterface myfunctionInterface01 = (int num01, int num02) -> {
            return num01+num02;
        };
        MyfunctionInterface myfunctionInterface02 = (num01,num02) -> {
            return num01+num02;
        };
        System.out.println(myfunctionInterface01.method03(10,20));
        System.out.println(myfunctionInterface02.method03(20,30));
    }
}
