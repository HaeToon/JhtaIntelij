public abstract class Calc {
    int a,b;
    public void setValue(int a ,int b) {
        this.a=a;
        this.b=b;
    }
    //메서드의 정의만 있으면 추상메서드가되고 추상메서드를 하나라도 가지고있으면
    //추상 클래스가 된다.
   abstract int calculate();
}
