import java.util.Scanner;
//추상메소드를 하나라도 가지고있으면 추상클래스가 된다. 반드시abstract를 붙여야 한다.
abstract class Converter {
    abstract protected double convert(double src);
    abstract protected String getSrcString();
    abstract protected String getDestString();
    protected double ratio;
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
        System.out.println("바꾸고싶은 "+getSrcString()+"를 입력하세요 >> ");
        double val = sc.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과 : "+res+getDestString()+"입니다.");
        sc.close();
    }
}