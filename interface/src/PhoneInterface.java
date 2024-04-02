public interface PhoneInterface {
    final int TIME_OUT=10000;
    public void sendCall();
    public void receveCall();
    default void printLogo(){
        System.out.println("==로고==");
    }

}
