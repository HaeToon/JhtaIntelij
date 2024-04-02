public class C extends B{
    public C() {
//        super(3); // 부모 클래스 B에 기본생성자가 없을경우 super는 항상 첫줄에
        System.out.println("나는 C생성자");
    }
    public C(int i) {
        super(i);
        System.out.println("나는 매개변수 i를 가지는 C생성자");
    }
}
