abstract class Calculator {

    int num;
    abstract public int add(int a, int b);
    abstract public int sub(int a, int b);
    abstract public int mul(int a, int b);
    abstract public int div(int a, int b);
}
class SamsungClaculator extends Calculator{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
class LGCalculator extends Calculator{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b<0?b-a:a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
public class GoodCalculator{
    public static void main(String[] args) {
        Calculator calculator = new LGCalculator();
        System.out.println(calculator.sub(5,10));
    }
}
