package sample;

public class Sample {
    public int a;
    private int b;
    public int c;

    public int getB() { //getter만하면 읽기전용
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    // field멤버는 private로 막고
    //메서드를통해서 외부로 노출시킨다.

}
