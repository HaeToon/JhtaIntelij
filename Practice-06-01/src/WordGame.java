import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class WordGame {
    private Vector<Word> v = new Vector<>();
    Scanner scanner = new Scanner(System.in);

    public WordGame() {
        v.add(new Word("constructor", "생성자"));
        v.add(new Word("overriding", "재정의"));
        v.add(new Word("extends", "상속"));
        v.add(new Word("array", "배열"));
        v.add(new Word("string", "문자열"));
        v.add(new Word("character", "문자"));
        v.add(new Word("integer", "정수"));
        v.add(new Word("double", "실수"));
        v.add(new Word("abstract", "추상"));
        v.add(new Word("implements", "구현하다"));
    }

    void run() {
        System.out.println("java 단어 테스트를 시작합니다. -1을입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "개의 단어가 저장되어있습니다.");
        while (true) {
            System.out.println("1 : 저장하기 2 : 테스트 시작 3. 종료");
            int menu = scanner.nextInt();
            if(menu==1) {
                input();
            }else if(menu ==2){
                choice();
            }else if(menu ==3) {
                finish();
                break;
            }

        }

    }

  void input (){
        while(true){
            System.out.println("저장할 단어와 뜻을 입력해 주세요.그만 입력시 종료");
            String word = scanner.next();
            if(word.equals("그만"))break;
            System.out.println(word+"의 뜻을 입력해 주세요");
            String mean = scanner.next();
            v.add(new Word(word,mean));
        }
  }
    void choice() {
        while (true) {
            int random = (int) (Math.random() * 10);
            int answer = random;
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println(v.get(random).getWord() + "의 뜻은? -1 입력시 종료");
            for (int i = 0; i < 4; i++) {
                int randomAnswer = (int) (Math.random() * 10);
                System.out.print("(" + (i + 1) + ")" + v.get(randomAnswer).getMean() + "\t");
            }
            String myanswer = scanner.next();
            if(myanswer.equals("-1")){
                System.out.println("종료합니다.");
                break;
            }
            if(myanswer.equals(v.get(answer).getMean())) {
                System.out.println("정답입니다!");
            }else {
                System.out.println("틀렸습니다.");
            }

        }
    }
    void finish() {
        System.out.println("종료합니다.");
    }

}
