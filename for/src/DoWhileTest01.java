public class DoWhileTest01 {
    public static void main(String[] args) {
        //do while 문으로 a~z 까지 출력
        //반복문도 중첩가능
        char ch = 'a'; // 소문자 a = 97 대문자 A= 65
        System.out.print(ch+1);
        int count = 0;
        do {
            System.out.print(ch);
            ch++;
         //  ch=  (char) (ch + 1); 위와 같음
            count++;
        }
        while (ch <= 'z');
        System.out.println(count);
    }
}