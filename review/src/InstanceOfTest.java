
class Person{

}
class Student02 extends Person{

}
class Researcher extends Person{

}
class Professor extends  Researcher{

}
public class InstanceOfTest {
    //다형성
    static void printInstance(Person person){
        if(person instanceof Person) System.out.println("Person입니다."); //instanceof = 타입 판별기
        if(person instanceof Student02) System.out.println("Student입니다.");
        if(person instanceof Researcher) System.out.println("Researcher입니다.");
        if(person instanceof Professor) System.out.println("Professor입니다.");
    }
    public static void main(String[] args){
        printInstance(new Professor());
    }
}
