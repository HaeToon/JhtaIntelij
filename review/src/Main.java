class Student {
    int age;//멤버 , 필드 , 속성
    String name, nickName, adress; //멤버 , 필드 , 속성
    final int TOTAL = 10; //final은 값의 변경이 불가능하기때문에 선언과 동시에 초기화해주어야한다.

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Student(String name, int age, String nickName) {
        this.age = age;
        this.name = name;
        this.nickName = nickName;
    }

    public Student(String name, int age, String nickName, String adress) {
        this.age = age;
        this.name = name;
        this.nickName = nickName;
        this.adress = adress;
    }

    void print() { //함수 , 생성자
        System.out.println("출력시마스~");
    } //메서드

    void print(int num) { //메서드 오버로드 매개변수의 타입과 개수를 따진다 return은 상관없음.
        System.out.println(num + "출력시마스~");
    }

    int print(double num) { //메서드 오버로드 매개변수의 타입과 개수를 따진다 return은 상관없음.
        System.out.println(num + "출력시마스~");
        return (int) num;
    }

    void printNum(int num) { //메서드 오버로드 매개변수의 타입과 개수를 따진다 return은 상관없음.
        System.out.println(num + "출력시마스~");
    }

    private String addZero(int num) {
        return num < 10 ? "0" + "num:" : "" + num;
    }

    public class Main {
        public static void main(String[] args) {
            //java는 class로 움직인다.
            Student student01 = new Student();
            Student student02 = new Student();

            student01.adress = "지구";
            student01.name = "태훈";
            student01.nickName = "허뱅";
            student01.age = 29;

            student02.adress = "지구";
            student02.name = "태훈";
            student02.nickName = "허뱅";
            student02.age = 29;
        }
    }
}
