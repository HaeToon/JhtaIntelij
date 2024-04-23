import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentTest02 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("허태훈", 1, 86));
        studentList.add(new Student("유재석", 3, 92));
        studentList.add(new Student("박명수", 3, 81));
        studentList.add(new Student("노홍철", 1, 75));
        studentList.add(new Student("정형돈", 2, 96));
        studentList.add(new Student("정준하", 4, 93));
        studentList.add(new Student("강호동", 4, 71));
        //3학년의 평균
        //1.Stream 생성 -> 중간연산 -> 최종결과
        Stream<Student> studentStream = studentList.stream();//stream생성
        //2.중간연산
        Stream<Student> gradeStream =studentStream.filter(student -> student.getGrade()==3);
        IntStream scoreStream = gradeStream.mapToInt(Student::getScore);
        OptionalDouble optionalDouble = scoreStream.average();  //Optional 은 null 이어도 됩니다.
        double grade02Avg = optionalDouble.getAsDouble();
        System.out.println("3학년 평균값"+grade02Avg);
        double grade03Avg = studentList.stream()
                .filter(student -> student.getGrade()==3)
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        List<String>fruits= Arrays.asList("orange","banana","apple","berry","berry");
        fruits.stream() //생성
                .distinct() //중간연산
                .forEach(System.out::println); //최종연산
        System.out.println();
        studentList.stream()
                .sorted()
                .sorted(Comparator.reverseOrder())
                .forEach(student -> {
                    System.out.print(student.getName()+":"+student.getScore()+",");
                });

    }
}
