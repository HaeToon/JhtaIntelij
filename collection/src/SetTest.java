import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("grape");
        set.add("orange");
        set.add("apple");
        //set 은 중복되면 들어가지 않음 , 순서가 없다.
        System.out.println(set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        String arr[]={"H","A","P","P","Y"};
        Set<String> set02 = new LinkedHashSet<>(Arrays.asList(arr)); // 순서가필요할경우 HashSet 말고 LinkedHashSet사용
        Iterator<String> iterator02 = set02.iterator();  //중복된 p가 사라짐.
        while (iterator02.hasNext()) {
            System.out.println(iterator02.next());
        }
        String distinctArr[]=set02.toArray(new String[0]);
        System.out.println(Arrays.toString(distinctArr));
    }
}
