import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        int age = 29;
        String str01 = "aaa"; //String Pool
        char chars[] = {'a', 'a', 'a'};
        String str02 = new String(chars);
        String str03 = new String("abc");
        System.out.println(str01 == str02); //==는 주소값을 비교하는것이라 다름.
        String str04 = "aaa";
        System.out.println(str01 == str04);
        System.out.println(System.identityHashCode(str01) + "===" + System.identityHashCode(str04));
        String str05 = "java";
        String str06 = "C++";
        System.out.println(str05.compareTo(str06));// 사전비교 같으면 0 나중에 나오는게 더 크다
        String jumin = "1234567";
        System.out.println(jumin.charAt(0));
        char ch = jumin.charAt(0);
        System.out.println(ch); //ch 가 1이면 남자 아니면 여자
        if (ch == '1' || ch == '3') {
            System.out.println("남자");
        } else {
            System.out.println("여자");
        }
        String id = "heo27";
        System.out.println(id.isEmpty()); //isEmpty는 문자열의 길이를 따짐.
        System.out.println(id.isBlank()); //isEmpty는 문자열의 길이를 따짐.

        System.out.println(jumin.startsWith("1"));

        String name = "태훈";
        System.out.printf("hello my name is %s \n",name);
        //html,jsp,*thymeleaf* ,pug, mustache
        String msg = """
                <html>
                <head>
                </head>
                <body>
                <h1>%s</h1>
                <h2> age : %d </h2>
                </body>
                </html>
                """.formatted(name,age);
        System.out.println(msg);
        String alertMsg = "id/pw 확인해주세욧";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello my name is ");
        stringBuilder.append(name);
        stringBuilder.append(" my age is ");
        stringBuilder.append(29);
        stringBuilder.append("<alert>");
        stringBuilder.append(alertMsg);
        stringBuilder.append("</alert>");
        System.out.println(stringBuilder.toString());

        String msg02 = " m s g ";
        //정규표현식 unix에서 사용하던 문자열 찾기.
        System.out.println(msg02.trim()); //trim = 공백제거 양끝에것만 적용 사이의 공백은 적용x
        System.out.println(msg02+"=="+msg02.replaceAll("\\s+","")); //replaceAll 중간의 공백도 제거

        String jumin02 = "961007-1234567";

        System.out.println(jumin02.substring(0,6)); //0~6번째까지
        System.out.println(jumin02.substring(7)); //7번부터 나머지

        String query ="name=태훈&id=gxg4205&age=29";
        String stringArray[] = query.split("&");   //split은 문자열 을 분리해 배열로 리턴
        System.out.println(stringArray[0]);

        StringTokenizer stringTokenizer = new StringTokenizer(query,"&");
        while(stringTokenizer.hasMoreTokens()){
        System.out.println(stringTokenizer.nextToken());
        }

        String txt01 ="유재석";
        String txt02 ="박명수";
        String txt03 ="노홍철";
        String txt04 ="정형돈";
        //유재석/박명수/노홍철/정형돈

//        StringBuilder stringBuilder02 = new StringBuilder();
//        stringBuilder02.append(txt01);
//        stringBuilder02.append(txt02);
//        stringBuilder02.append(txt03);
//        stringBuilder02.append(txt04);

        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(txt01);
        stringJoiner.add(txt02);
        stringJoiner.add(txt03);
        stringJoiner.add(txt04);
        System.out.println(stringJoiner.toString());

        List<String> muhan = Arrays.asList(txt01,txt02,txt03,txt04);

        String muhanStr = muhan.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(muhanStr);

        //Apcha.commons.StringUtil 라이브러리 잇어야 쓸수있음.

    }
}
