import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args){
        //Map key value
        //Sprig 에는 Map이 json으로 변환되는 것이 내재되있음
        //<키,밸류>
        Map<String,String> dictionary = new HashMap<String,String>();
        dictionary.put("Apple","사과");
        dictionary.put("Banana","바나나");
        dictionary.put("Strawberry","딸기");
        System.out.println(dictionary.get("Apple")); // get(key)를 입력해야함. retrun value
        System.out.println(dictionary.size());
        System.out.println(dictionary.containsKey("Apple"));//dictionary.containsKey("Apple") Apple key가 있는지 true false 반환
        System.out.println(dictionary.containsValue("사과"));//dictionary.containsValue("사과") 사과 value가 있는지 true false 반환
        if(!dictionary.containsKey("Apple")) {
            dictionary.put("Apple","부사");
        }
        dictionary.putIfAbsent("Apple","아오리");
        dictionary.putIfAbsent("Cat","고양이");
        System.out.println(dictionary.get("Apple"));
        System.out.println(dictionary.get("Cat"));
        System.out.println(dictionary.size());
        // key를 뽑아올수있다.
        Set<String> keySet = dictionary.keySet();  //key값 뽑아오기
        Iterator<String> iterator = keySet.iterator(); //key에서 순환자만들기
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + "==="+ dictionary.get(iterator.next())); //Key 값 만 출력+dictionary.get(iterator.next())로 value값도 출력
        }
        //foreach 반복문  entry  = 요소하나하나 key,value의 묶음?
        for(Map.Entry<String,String> entry:dictionary.entrySet()) {
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }
    }
}
