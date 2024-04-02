import sample.Sample;

public class AccessTest {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a = 10;
        sample.c = 5;
        //public 은 모두에게서 접근가능
        //private는 클래스 내부에서만 접근가능
        //default는 같은 패키지 내에서만 접근가능
    }
}
