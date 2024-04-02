import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        //String 생성 방법 3가지
        char chList[] = {'a', 'b', 'c', 'd'};
        String str01 = "abcd"; //리터럴 테이블에 생성됨. heap메모리 x
        String str02 = new String("abcd");
        String str03 = new String(chList);
        String str04 = str02;
        String str05 = "abcd";
        String str06 = new String("abcd");
        System.out.println(str01 == str02); //String은 == 사용 x 내용비교는 .equals
        System.out.println(str04 == str02);
        System.out.println(str05 == str01); // 리터럴(값을쓰는방식) 이 같으면 같다.(새로운 주소를 생성하지않고 같은 주소로 봄)
        System.out.println(str06 == str02); //new = heap메모리에 생성  2번6번은 내용은 같지만 생성되는곳이 달라서 false임.
        //str 01 은 리터럴 테이블에 주소가 생성되고 값이 들어감.
        //str 05 는 리터럴 테이블에있는 값(str 01이 생성한것)이 입력한 값이 같으므로 주소를공유함.
        //.equals는 내용비교 ==는 주소비교

        //String 객체는 불변객체 immutable.
        System.out.println(str02.concat(str04));
        System.out.println(str02);

        String text = "abcd";
        System.out.println(text.charAt(0)); //배열같이 0~3에 abcd가 들어감. 0=a 1=b 2=c 3=d
        System.out.println(text.concat("efgh")); // concat = 연결하는것 abcdefgh
        System.out.println(text.toUpperCase().toLowerCase()); // uppercase 대문자 lowercase 소문자
        System.out.println(text.compareTo("")); // compareTo 같으면 0 다른갯수만큼-1
        System.out.println(text.contains("ab")); // contains 안의 내용을 포함하는지 boolean 으로 true false 판별 연결된것으로 판단
        System.out.println(text.length()); // text의 길이값
        System.out.println(text.substring(1)); // 1부터 나머지 글자를 끊고싶을때
        System.out.println("동해물과 백두산이 마르고 닳도록 하느님이".substring(0, 10) + "..."); // 0~10개를 끊어서 표현


        System.out.println("      동해물과 백두산이 마르고 닳도록 하느님이    ".trim().substring(0, 10) + "...");
        //.trim() 앞,뒤의 공백을 없앰. 중간공백은 x
        System.out.println("동해물과 백두산".replace("동해", "서해"));
        // replace 동해를 서해로 바꾼다.
        System.out.println("동해물".indexOf("동"));
        //indexOf 글자의 순서를 0~ 리턴함 동=0 해=1 물=2 -1은 없는것.

        String jumin = "880112-1765432";
        String first = jumin.substring(0, 6);
        String second = jumin.substring(7);
        System.out.println(jumin.substring(0, 6));
        System.out.println(first);
        System.out.println(second);

        boolean isMan = second.charAt(0) == '1' || second.charAt(0) == '3' ? true : false; //3항연산자
        boolean isWoman = second.charAt(0) == '2' || second.charAt(0) == '4' ? true : false; //3항연산자
        System.out.println(isMan);
        System.out.println(isWoman);
        System.out.println("    ".trim().isEmpty()); //비어있는지 아닌지 따짐. 문자열의 길이를 따짐. 공백도 문자로 치기때문에 false trim으로인해 true
        System.out.println("    ".trim().isBlank()); // blank는 공백이면 빈걸로 처리함.

        //주의해야하는것 줄넘김부분
        //jdk1.8부터는 엔터누르면 자동으로+붙음
        String aaa ="<html>" +
                "<head></head>" +
                "<body></body>" +
                "<html>";
        //jdk17버전부터
        String bbb = """
                <html>
                    <head></head>
                    <body></body>
                <html>
                """;
        System.out.println(aaa);
        System.out.println(bbb);

        //StringBuffer 가변(mutable) 객체 String 불변(immutable) 객체
        StringBuffer stringBuffer = new StringBuffer("abcd"); //StringBuffer 는 선언하고 사용해야함.
        System.out.println("stringBuffer.hashCode()==="+stringBuffer.hashCode());
        stringBuffer.append("efgh"); //append = 글자추가
        System.out.println("stringBuffer.hashCode()==="+stringBuffer.hashCode()); // 값이 변해도 주소가같음. 가변객체이기떄문
        System.out.println(stringBuffer);  // 기존abcd에 efgh가 추가됨.
        String ccc="abcd";
        System.out.println(ccc.hashCode());//이것과는 다름.
        ccc = ccc.concat("efgh");  //ccc는 변하지 않음. , 기존 abcd에 추가되는것이아닌 제거된후 새로운 abcdefgh가 생성됨
        System.out.println(ccc.hashCode());
    }
}
