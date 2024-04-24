import java.util.*;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        //모아두는것 collection
        //List,  Set , Map 을 많이씀.
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        System.out.println(intList.get(0));
        System.out.println(intList.size());
        System.out.println(intList.contains(100));
        System.out.println(intList.contains(10));
        intList.remove(0);
        System.out.println(intList.contains(10));
        System.out.println(intList.get(0));

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("berry");
        fruits.add("peach");
        fruits.add("orange");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
        Iterator iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        fruits.forEach(s -> System.out.println(s));

        String animals[] = {"panda", "rion", "tiger", "bear", "rabbit"};
        List<String> animalList = Arrays.asList(animals);
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println(animalList.get(i));
        }
        animals[1] = "wolf";
        animalList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
//        animalList.add("turtle"); Arrays.asList(배열) = 배열의 길이만큼 List의 길이가 고정된다.
        animalList.forEach(s -> System.out.println(s));
        //asList로 배열을 List로바꿔도 배열울 계속 참조할수있다.

        List<String> animalList02 = new ArrayList<>(Arrays.asList(animals));
        animals[0] = "shark";
        System.out.println(animalList02.get(0)); //새로만들어서 animals의 참조에 영향을 받지않는다.
        //new ArrayList<>(새로만들것)

        Set<String> hashSet = new HashSet<>();
        hashSet.add("홍길동");
        hashSet.add("고길동");
        hashSet.add("이순신");
        hashSet.add("김유신");
        hashSet.add("홍길동");
        System.out.println(hashSet.size()); //set은 중복을 허용하지않기때문에 홍길동은 1개로침.

        String stringArray[] = {"홍길동", "고길동", "이순신", "김유신", "홍길동"};
        Set hashset02 = new LinkedHashSet<>(Arrays.asList(stringArray)); //set은 순서를보장안하고 중복을 제거한다.  순서를 보장하려면 생성할떄 new LinkedHashSet으로 생성해야함.
        System.out.println(hashset02.size());

        Iterator iterator02 = hashset02.iterator();
        while (iterator02.hasNext()) {
            System.out.println(iterator02.next());
        }

        hashset02.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        hashset02.forEach(o -> System.out.println(o));
        //set은 순서보장 안함
        //set은 중복제거용으로 사용하고 List로 바꾸면  순서로 값을 가져올수있다,
        List<String> distinctList = new ArrayList<>(hashset02);
        for (int i = 0; i < distinctList.size(); i++) {
            System.out.println(distinctList.get(i));
        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("apple", "사과");
        hashMap.put("banana", "바나나");
        hashMap.put("orange", "오렌지");
        hashMap.put("peach", "복숭아");
        hashMap.put("melon", "멜론");
        System.out.println(hashMap.get("apple"));
        Set<String> keySet = hashMap.keySet();
        keySet.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        hashMap.remove("apple");
        keySet.forEach(s -> System.out.println(s));
        hashMap.clear(); //hashMap의 내용을 모두 지움
        //db에서 데이터가 들어올떄
//        List<HashMap<String,String>>dbList = new ArrayList<>();

        String stringArray02[] = {"홍길동", "고길동", "이순신", "김유신", "홍길동", "고길동", "이순신", "김유신"};
//        Set hashSet02 = new LinkedHashSet(Arrays.asList(stringArray02));
//            Iterator iterator1 = hashSet02.iterator();
        Map<Integer, String> hashMap02 = new HashMap<>();
        for (int i = 0; i < stringArray02.length; i++) {
            hashMap02.put(i + 1, stringArray02[i]);
        }
        for (int i = 0; i < hashMap02.size(); i++) {
            System.out.println(hashMap02.get(i + 1));
        }
        System.out.println("중복제거 set");
        Set<String> set = new HashSet<>(Arrays.asList(stringArray02));
        Map<Integer, String> hashMap03 = new HashMap<>();
        set.forEach(new Consumer<String>() {
        int count=1;
            @Override
            public void accept(String s) {
                System.out.println(s);
                hashMap03.put(count,s);
                count++;
            }
        });
//        int count=1;
//        for(String str :set){
//            hashMap03.put(count,str);
//            count++;
//        }
        for(int i=0; i<hashMap03.size();i++) {
            System.out.println(hashMap03.get(i));
        }
        //stram 입출력 InputStream , OutputStream
        //Writer / Reader
    }
}
