public class LGPhone implements MobilePhoneInterface,Mp3Interface { //interface는 implement 로 사용함

    @Override
    public void sendCall() {
        System.out.println("전화를 겁니다");
    }
    @Override
    public void receveCall() {
        System.out.println("전화 왔습니다.");
    }

    @Override
    public void sendSMS() {
        System.out.println("메세지를 보냅니다.");
    }

    @Override
    public void reciveSMS() {
        System.out.println("메세지를 받습니다.");
    }

    @Override
    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    @Override
    public void stop(){
        System.out.println("음악을 중지합니다.");
    }
}

