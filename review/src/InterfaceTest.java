
//interface IPlay Playable PlayImp등 // interface의 이름을 정할떄는 가계로 I를앞에 붙이거나 뒤에 able 을붙임
interface PhoneInterface {
//    String name; //interface는 멤버필드를 정의할수없음. 상수는 가능
    final int TIMEOUT = 10000;
    public abstract void send();
     void receive();     //interface 는 public abstract 생략가능
    default void showLogo(){  //interface에서 코드를 구현하려면 default를 이용해야함.
        System.out.println("갤럭시");
    }

}
class SamsungPhone implements MobileInterface{

    @Override
    public void send() {
        System.out.println("갤뚜룱전화걸기");
    }

    @Override
    public void receive() {
        System.out.println("갤뚜룪전화받기");
    }
    public void showPen(){
        System.out.println("pen을 쓸수있습니다");
    }

    @Override
    public void sendSMS() {
        System.out.println("sms를 보냅니다");
    }

    @Override
    public void receiveSMS() {
        System.out.println("sms를 받습니닷");
    }
}
interface MusicPhoneInterface extends MobileInterface,MP3Interface{//interface다중상속가능
    void playMusic();
}
class IPhone implements MobileInterface,MusicPhoneInterface{ //Interface다중구현가능

    @Override
    public void send() {
        System.out.println("아이롱전화걸기");
    }

    @Override
    public void receive() {
        System.out.println("아이롱전화받기");
    }

    @Override
    public void sendSMS() {
        System.out.println("아이롱 문자보내기");
    }

    @Override
    public void receiveSMS() {
        System.out.println("아이롱 문자받기");
    }

    @Override
    public void play() {
        System.out.println("무직 스타트");
    }

    @Override
    public void stop() {
        System.out.println("무직 스탑");
    }

    @Override
    public void playMusic() {
        System.out.println("음악 시작");
    }
}
interface  MobileInterface extends PhoneInterface{
    void sendSMS();
    void receiveSMS();
}
interface MP3Interface {
    void play();
    void stop();

}
public class InterfaceTest {
    public static void main(String[] args) {
        //느슨한 결합 usb규격만 맞으면 아무거나 써도됨.
        SamsungPhone phone = new SamsungPhone(); //강한결합  한가지밖에 못함. ex) apple 제품
        PhoneInterface phone01 = new SamsungPhone();
        PhoneInterface phone02 = new IPhone();
        MobileInterface phone03 = new IPhone();
        MobileInterface phone04 = new SamsungPhone();
        phone01.send();
        phone02.send();
        phone03.sendSMS();
        phone04.receiveSMS();
    }
}
