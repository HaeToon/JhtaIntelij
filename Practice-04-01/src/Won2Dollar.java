public class Won2Dollar extends Converter{
//Converter의 추상메소드 3가지를 구현해야함.

    public Won2Dollar(double ratio) {
        this.ratio=ratio;
    }
    @Override
    protected double convert(double src) {
        return src/ratio;
    }
    @Override
    protected String getSrcString() {
        return "원화";
    }
    @Override
    protected String getDestString() {
        return "달러";
    }
    public static void main(String[] args) {
        Won2Dollar won2Dollar=new Won2Dollar(1350);
        won2Dollar.run();
    }
}
