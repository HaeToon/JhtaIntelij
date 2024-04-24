package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Stream01 {
    public static void main(String[] args) {
        String fruits02[] = {"apple", "banana", "kiwi", "orange", "peach", "apple", "orange", "kiwi"};
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "orange", "peach", "apple", "orange", "kiwi");
        Stream<String> fruitsStream = fruits.stream();
        //생성 , 중간연산 , 결과반환
//        fruitsStream.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        //System.out.println(s);
//        fruitsStream.forEach( s -> System.out.println(s));
//        fruitsStream.forEach(System.out::println);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("태훈", 29));
        studentList.add(new Student("현홍", 29));
        studentList.add(new Student("우연", 28));
        studentList.add(new Student("미리", 29));
        studentList.add(new Student("아현", 29));
        studentList.stream().forEach(student -> System.out.println(student.getName()));
        Student students[] = {
                new Student("태훈", 29),
                new Student("현홍", 29),
                new Student("우연", 28),
                new Student("미리", 29),
                new Student("아현", 29),
        };
        Stream<Student> studentStream02 = Arrays.stream(students);
        studentStream02.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student.getName() + student.getAge());
            }
        });
        //distinct() = 중복제거
        fruitsStream.distinct().forEach(s -> System.out.println(s));
        //최종연산이 끝난 스크림은 재활용 안됨.
//        fruitsStream.filter(s -> s.length()<5)
//                .forEach(s -> System.out.println(s)); //에러발생
        fruits.stream().filter(s -> s.length() < 5)
                .forEach(s -> System.out.println(s));

        fruits.stream().distinct().filter(s -> s.length() < 5).forEach(s -> System.out.println(s));

//        studentList.stream()
//                .mapToInt(value -> value.getAge())
//                .forEach(value -> System.out.println(value));

        List<Integer> ageList = studentList.stream()
                .map(value -> value.getAge())
                .collect(Collectors.toList());

        ageList.forEach(integer -> System.out.println(integer));

        List<String> nameList = studentList.stream()
                .map(value -> value.getName())
                .collect(Collectors.toList());

        nameList.forEach(s -> System.out.println(s));

        List<String> nameList02 = studentList.stream()
                .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
//                .map(value ->value.getName())
                .map(Student::getName)
                .collect(Collectors.toList());
        nameList02.forEach(s -> System.out.println(s));

        //옵셔널 기억!
        boolean result = Arrays.stream(fruits02)
//                .anyMatch(s -> s.length()<5);  //하나라도 조건 만족시 true
                .allMatch(s -> s.length() < 5); //모두 조건만족시 true
        System.out.println(result);

    }
}
