public class Km2Mile extends Converter{
// Converter converter = new Converter(); xxxxx 추상메소em는 생성자를 만들수없다.
public Km2Mile(double ratio){
    this.ratio=ratio;
}
    @Override
    protected double convert(double src) {
        return src/ratio;
    }

    @Override
    protected String getSrcString() {
        return "Km";
    }

    @Override
    protected String getDestString() {
        return "mile";
    }

    public static void main(String[] args) {
        Km2Mile km2Mile = new Km2Mile(1.60934);
        km2Mile.run();
    }
}
