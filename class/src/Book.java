public class Book {
    String title;
    String author;
    //생성자 두개

    Book() {
        this("",""); //this는 무조건 첫줄에
        System.out.println("나는 this로 호출되었습니다.");
    }
    Book(String title){
//        this.title = title;
//        this.author= "작자미상";
        this(title,"작자미상"); // this는 자기자신을 호출가능함.
    }
    Book(String title, String author){ // this는 함수로도 사용가능
        this.title = title;
        this.author = author;
    }
}
