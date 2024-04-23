import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {
    public static void main(String[] args){
        //Collection List,Set,Map
        List<String>fruits01= Arrays.asList("apple","berry","oragne","banana");
        Iterator<String> iterator = fruits01.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("============================");
        List<String>fruits02= Arrays.asList("apple","berry","oragne","banana");
        Stream<String> fruits02Stream = fruits02.stream(); //fruits를 stream으로 만들어줌.
        fruits02Stream.forEach(s ->
            System.out.println(s+"/"));
        int intArrays[] = {1,2,3,4,5};
        IntStream intstream = Arrays.stream(intArrays);
        intstream.forEach(i->{
            System.out.println(i+"/");
        });
        IntStream intStream01 = IntStream.range(1,10); //Stream을 만들어줌
        intStream01.forEach(System.out::print); //Stream은 한번 쓰면 끝이다.
        System.out.println();
        IntStream intStream02 = IntStream.rangeClosed(1,10);
        intStream02.forEach(i-> System.out.print(i));//다시쓰려면 다시 생성해야한다.
        //random 하게 생성
        IntStream randomIntstream01 = new Random().ints(10);
        randomIntstream01.forEach(i-> System.out.print(i+","));
        System.out.println();
        IntStream randomIntstream02 = new Random().ints(1,100)
                        .limit(10);
        //Stream은 중간연산 최종연ㅅ나 기능이 있는데 거의대부분 Stream을 리턴한다.
        randomIntstream02.forEach(i-> System.out.print(i+","));

        Stream<String> stringStream01 = Stream.of("허태훈","김현홍","최우연");
        Stream<String> stringStream02 = Stream.of(new String[]{"허태훈","김현홍","최우연"});

    }
}
