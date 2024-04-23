package functional09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class Student {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = (String name) -> System.out.println(name);
        consumer.accept("허태훈");
        IntConsumer intConsumer = (int value) -> System.out.println("학년 :" + value);
        intConsumer.accept(3);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("허태훈", 30));
        studentList.add(new Student("유재석", 57));
        studentList.add(new Student("정형돈", 55));
        studentList.add(new Student("노홍철", 43));
        studentList.add(new Student("박명수", 60));

        studentList.forEach(student -> {
        System.out.println("이름 : "+student.getName());
        });
        //Consumer는 소비자이고 매개변수는 있고 리턴값이없음.
        //Predicate 는 매개변수 하나를 갖고 boolean타입이므로 리턴이 true / false 이다.
        studentList.forEach(student -> System.out.println(student.getName()));
        Predicate<String>predicate = (str) -> {
            return str.length()>20 ? true:false;
        };
        Predicate<String>predicate02 = (str) -> str.length()>20 ? true:false;
        System.out.println(predicate.test("xogns"));
        BiPredicate<String,String> biPredicate= ( s,s2) -> s.equals(s2);
        System.out.println(biPredicate.test("허태훈","허태훈"));


        DoubleConsumer doubleConsumer;

    }
}
