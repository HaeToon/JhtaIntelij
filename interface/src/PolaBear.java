public class PolaBear extends Mamal implements Swimmable,Huntable{

    @Override
    public void swim() {
        System.out.println("곰은 수영을 합니다.");
    }

    @Override
    public void hunt() {
        System.out.println("곰은 사냥을 합니다.");
    }
}
