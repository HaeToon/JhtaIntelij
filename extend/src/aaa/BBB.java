package aaa;

public class BBB extends AAA {
    public void set() {
        pub=10;
        def=20;
        pro=30;
//        pri=40;  private는 같은패키지내에 상속받더라도 사용불가능.
    }

//    public BBB() {
//        System.out.println("난BBB");
//    }
}
