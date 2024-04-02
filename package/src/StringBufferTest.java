import java.util.StringTokenizer;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("a");
        System.out.println(stringBuffer.hashCode());
        stringBuffer.append(" pencil")              // 이어붙일때 append("");
                    .append(" very nice")
                    .append(" monami")
                    .insert(2,"ballpen") // 원하는 위치에 넣을떄 insert(num,"")
                    .delete(8,15) // 원하는만큼 지울때 delete(num,num) num~num삭제
                    .reverse(); // 글자하나하나를 역순으로 출력
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer);

        StringBuffer stringBuffer02 = new StringBuffer("This");
        stringBuffer02.append(" is pencil");
        System.out.println(stringBuffer02);
        stringBuffer02.insert(7," my");
        System.out.println(stringBuffer02);
        stringBuffer02.replace(8,10,"your"); // 8~10에 있는 문자를 your로 변경 replace(num,num,"")
        System.out.println(stringBuffer02);
//        stringBuffer02.repeat("a",5);
//        System.out.println(stringBuffer02);
        stringBuffer02.setLength(3); // setLength(num) num만큼의 글자를 두고 나머지를 다 지움
        System.out.println(stringBuffer02);

        String html = """
                <html>
                
                </html>
                """;
        StringBuffer html2 = new StringBuffer();
        html2.append("<html>")
                .append("<head>")
                .append(("</head>"))
                .append("<body>")
                .append("</body>")
                .append("</html>");

        StringBuffer js = new StringBuffer();
        js.append("<script>")
                .append("alert('아이디 패스워드가 일치하지 않습니다.');")
                .append("</script>");

        //일반적인경우 String 사용
        //특수한경우엔 StringBuffer 사용

        String query = "name=허태훈&adress=서울시&age=29";
        StringTokenizer stringTokenizer = new StringTokenizer(query,"&"); //StringTokennizer 문자열을 특정한 문자로 쪼개는주는것
        for(int i=0; i<stringTokenizer.countTokens(); i++) {
            System.out.println(stringTokenizer.nextToken());
        }
        while(stringTokenizer.hasMoreElements()) { //asMoreElement 다음 값을 출력해라,

        }
        String splitSrt[] = query.split("&"); // Tokennizer의 역할과 같음
        System.out.println(splitSrt[0]);
        System.out.println(splitSrt[1]);
        System.out.println(splitSrt[2]);

    }
}
