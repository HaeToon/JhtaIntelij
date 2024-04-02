public class WrapperTest {
    public static void main(String[] args) {
//        int num ="10";
//    int num =Integer.parseInt("10"); //Integer num 을써도됨
        //Integer num = Integer.parseInt("10")
        //Boxing 기본타입을 wrapper class로
        //unboxing
//        Integer num01 = Integer.valueOf("10"); 이전에는 이렇게썻음.
//                int num02 = num01.intValue();
//        int num01 = 10;
//        Integer num02 = 10;

        //프론트에서 백으로 넘겨주는 모든것은 Strig으로 넘어옴.
        int num =Integer.parseInt("10"); //문자열로 들어온 숫자를 숫자로 변경하는것을 많이씀
        boolean aa = Boolean.parseBoolean("true"); // String type으로 들어온 true를 boolean type true으로 변경
        System.out.println(aa);

        int num01 = 10;
        Integer num02 = Integer.valueOf(10);
        System.out.println(num01==num02);  // 값이 같으면 같다.

        char ch01 = '4';
        char ch02 = 'F';
        if(Character.isDigit(ch01)) {
            System.out.println("ch01은 숫자형 char입니다.");
        }
        if(Character.isAlphabetic(ch02)) {
            System.out.println("ch02는 캐릭터형 char입니다.");
        }
        String str = "Adwfawfafasfdsaasdawdawfazcxzcas";
        //String은 기본타입이 아닌 레퍼런스 타입이다. Wrapper가 없다.
        //String은 레퍼런스 타입이지만 기본타입처럼 사용가능.

    }
}
