import java.util.Arrays;
import java.util.Scanner;

public class BookQuiz01 {
    public static void main(String[] args) {
        //bookList를 5개 만들어서 제목과 저자를 입력받아 배열에넣고
        //제목과 저자를 출력하는 코드를 짜시오
        Book bookList[] = new Book[5];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<5; i++) {
            System.out.println("제목을 쓰시오");
            String title = scanner.nextLine();
            System.out.println("저자를 쓰시오");
            String author = scanner.nextLine();
            bookList[i]=new Book(title,author);
        }
        for (int i=0; i<5; i++) {
            System.out.println("제목은 "+bookList[i].title + " 저자는 " + bookList[i].author + " 입니다.");
            System.out.printf("제목은 %s , 저자는 %s 입니다.",bookList[i].title,bookList[i].author);
        }
//        Scanner scanner = new Scanner(System.in);
//
//        String bookList[][] = new String[5][2];
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("제목을 입력해주세요");
//            String title = scanner.next();
//            bookList[i][0] = title;
//            System.out.println("저자를 입력해 주세요");
//            String author = scanner.next();
//            bookList[i][1] = author;
//        }
//        System.out.println(Arrays.toString(bookList));
    }
}
