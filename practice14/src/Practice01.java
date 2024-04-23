import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Practice01 {
    public static void main(String[] args) {
        List<String> fruitList = Arrays.asList("apple", "banana", "apple", "mango", "strawberry", "banana", "mango");
        Set<String>setFruit = fruitList.stream().collect(Collectors.toSet());
        setFruit.forEach( s ->{
            if(s.startsWith("a"))
            System.out.println(s);
        });
    }
}
