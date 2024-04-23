import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamExam {
    public static void main(String[] args){
        List<String> fruitList = Arrays.asList("apple","banana","apple","mango","strawberry","banana", "mango");
        //Supplier , Consumer , Predicate , Function
        //startsWith
        //a로 시작하는것들 2개중에 distinct로 중복제거후 forEach로 해당하는만큼 반복후 출력
        fruitList.stream().filter( s -> s.startsWith("a")).distinct().forEach( s -> System.out.println(s));
    }
}
