import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    List<Word01> wordList01 = new ArrayList<>();
    // 배열
    int question[] = new int[4];

    public Quiz() {
        wordList01.add(new Word01("constructor", "생성자"));
        wordList01.add(new Word01("overriding", "재정의"));
        wordList01.add(new Word01("extends", "상속"));
        wordList01.add(new Word01("array", "배열"));
        wordList01.add(new Word01("string", "문자열"));
        wordList01.add(new Word01("character", "문자"));
        wordList01.add(new Word01("integer", "정수"));
        wordList01.add(new Word01("double", "실수"));
        wordList01.add(new Word01("abstract", "추상"));
        wordList01.add(new Word01("implements", "구현하다"));
        System.out.println("java단어 맞추기 테스트를 시작합니다. -1을누르면 종료합니다");
        System.out.println("현재 " + wordList01.size() + "개의 단어가 저장되어 있습니다.");
    }

    public void run() {
        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            makeEx();
            //문제출제

            int answer = (int) (Math.random() * 4); // 정답에서 랜덤하게 하나 뽑기
            int answerIdx = question[answer];
            System.out.println(wordList01.get(answerIdx).getEng() + "의 뜻은?");
            for (int i = 0; i < question.length; i++) {
                System.out.print("(" + (i + 1) + ")");
                System.out.print(wordList01.get(question[i]).getKor() + "/");
            }
            int choice = scanner.nextInt();
            if (choice == -1) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (choice - 1 == answer) {
                System.out.println("정답입니다.");
            }else {
                System.out.println("오답입니다.");
            }

        }
    }

    private void makeEx() {
        for (int i = 0; i < 4; i++) { // 4가지중 하나 넣기
            question[i] = (int)(Math.random()*wordList01.size());
            for (int j = 0; j < i; j++) {
                if (question[i] == question[j]) { // 넣은것 중복검사
                    i--;
                    continue;
                }
            }
        }
    }
}
