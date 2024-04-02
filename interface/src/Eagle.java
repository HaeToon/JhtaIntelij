public class Eagle extends Bird implements Flyable,Huntable{ //여러개의 interface 상속시 ,사용
    @Override
    public void fly() {
        System.out.println("독수리는 하늘을 날수 있습니다.");
    }

    @Override
    public void hunt() {
        System.out.println("독수리는 사냥을 합니다.");
    }
}
