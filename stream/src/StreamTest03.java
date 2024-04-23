import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamTest03 {
    public static void main(String[] args) {
        //Optional null 방지용 JPA에서 많이씀.
        List<Student> studentList = new ArrayList<>();
        /*
        OptionalDouble optionalDouble = studentList.stream()
                .filter(student -> student.getGrade() == 3)
                .mapToInt(Student::getScore)
                .average();
        System.out.println(optionalDouble); //Optional JPA 할때 많이 나옴. DB에서 값을조회할때 있는지없는지 따져봄.
        if (optionalDouble.isPresent()) { //값이 있으면
            System.out.println(optionalDouble.getAsDouble()); //값을표시
        } else {
            System.out.println("점수가 없습니다."); //값이없으면
        }
        */
        double optionalDouble = studentList.stream()
            .filter(student -> student.getGrade() == 3)
            .mapToInt(Student::getScore)
            .average()
            .orElse(0.0);

        int scoreArray[] = {50,60,70,80,90};
        boolean all100less = Arrays.stream(scoreArray)
                .allMatch(value -> value< 100); //allMatch = 모든 값을이 조건을 만족해야함. 만족하면 true 아니면 false 리턴
        System.out.println(all100less);
        boolean all81great = Arrays.stream(scoreArray)
                .anyMatch(value -> value>81);
        System.out.println(all81great); //anyMatch = 모든 값중 하나가 만족하면 return true 아니면 false
        boolean none100great = Arrays.stream(scoreArray)
                .noneMatch(value -> value>99);
        System.out.println(all81great); //noneMatch = 일치하는게 하나도 없을경우 return true 아니면 false
        long total =Arrays.stream(scoreArray).count();
        System.out.println(total);
        long totalSum =Arrays.stream(scoreArray)
                        .sum();
        System.out.println(totalSum);
        int max = Arrays.stream(scoreArray).max().getAsInt();
        System.out.println(max);
        int totalSum02 = Arrays.stream(scoreArray).reduce((left, right) ->left+right)
                .getAsInt();
        System.out.println(totalSum+ "====="+totalSum02);
        int totalSum03 = Arrays.stream(scoreArray).reduce(10,(left, right) ->left+right);
        System.out.println(totalSum+ "====="+totalSum02+"====="+totalSum03);

        List<String>fruits= Arrays.asList("orange","banana","apple","berry","berry","apple");
        Set<String>setFruits =fruits.stream().collect(Collectors.toSet()); //set은 중복을 허용하지않으므로 중복제거가능
        setFruits.forEach(s -> {
            System.out.println(s.startsWith("a"));
        });

        Map<String,String>mapFruits =fruits.stream().distinct().collect(Collectors.toMap(str ->str.toUpperCase(),str ->"=map="+str));
        mapFruits.forEach((s, s2) -> {
            System.out.println(s+":"+s2);
        });
    }
}
