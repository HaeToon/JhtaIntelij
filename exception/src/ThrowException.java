class DogxxException extends RuntimeException {

}
public class ThrowException {
    public void sayHello(String msg) {
        if (msg.equals("개xx")) {
//            return;
            throw new DogxxException();
        }
        System.out.println("Hello world" + msg);
    }
    public static void main(String[] args) {
        ThrowException throwException = new ThrowException();
        try {
            throwException.sayHello("야호");
            throwException.sayHello("개xx");
        } catch (DogxxException e) {
            System.out.println("DogException이 발생했습니다.");
        }
    }
}
