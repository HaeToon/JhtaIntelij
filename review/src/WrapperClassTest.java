public class WrapperClassTest {
    public static void main(String [] args){
        String num ="10";
        //boxing unboxing
        int num02 = Integer.parseInt(num);
        System.out.println(num02+10);
        //Wrapper class 는 primitive를 wrapping한다.
        Integer num03 = Integer.valueOf(10);
        //Wrapper class는 new연산자를 사용하지않는다.
//        Integer num03 = new Integer(10);
         boolean isTrue01 = Boolean.valueOf("true");
         boolean isTrue02 = Boolean.parseBoolean("true");
         if (isTrue01) System.out.println("레알참트루");
         if (isTrue02) System.out.println("진초막참트루");
         double d=Double.parseDouble("3.14");
        System.out.println(d);
        //값을 바꿀때는 parse~~ , toString() 등을 쓴다.
        //숫자, 정수, 문자열, boolean
    }
}
