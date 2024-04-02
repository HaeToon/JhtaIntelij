class Person { // 클래스 속의 클래스 생성시 접근지정자를 붙이지않는다..
    String name;
    String id;
    public Person(String name) {
        this.name=name;
    }
    public Person() {

    }
    public void eat(Snack snack) {
        snack.open();
    }
//    public Person(){}
}
class Student extends Person {
    String grade;
    String department;
    public Student(String name) {
        super(name);
        this.name=name;
    }
}
class Animal {
    String hairColor;
    String leg;
}
class Snack {
    public void open() {
        System.out.println("과자 봉지를 뜯습니다.");
    }
}
class Oreo extends Snack {

}
class Sawoo extends Snack {

}
class PotatoChip extends Snack {

}
public class UpCastingTest {
    public static void main(String[] args) {
        Student student = new Student("허태훈");
        student.id="111";
        student.department="컴퓨터";

        Person person = student; // 업캐스팅하여 type이 person이 되어 student의 department와 grade를 사용하지못함.

//        Animal animal = student; // animal이 person을 상속하지못해서 student를 업캐스팅할수없음
        Sawoo sawoo = new Sawoo();
        Oreo oreo = new Oreo();
        person.eat(oreo);
        Person person02 = new Person();

        Student student02 = (Student)person02; //다운캐스팅시에는 타입을 명시해야함. 부모클래스의 서브클래스중 어디에 속하는지 명시해야함.

        student02.grade="3";
        student02.department="기게";
    }
}
