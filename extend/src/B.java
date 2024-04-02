public class B extends A{
    public B(int num) {
        System.out.println("나는 매개변수 num을 가지는B생성자");
    }
    public B() { // 아무것도안쓰면 기본생성자를 호출함
        System.out.println("나는 B생성자");
    }
}
