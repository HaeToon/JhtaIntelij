package functional06;
interface MyFunctionInterface{
    double methodCall();
}
class MyMath{
    public double print(){
        return Math.random();
    }
}
public class Lamda06 {
    public static void main(String[] args){
        MyFunctionInterface myFunctionInterface01 = Math::random;
        double result01 = myFunctionInterface01.methodCall();
        System.out.println("result==="+result01);
        MyFunctionInterface myFunctionInterface02 =Math::random;
        double result02=myFunctionInterface02.methodCall();
        System.out.println("result==="+result02);

    }
}
