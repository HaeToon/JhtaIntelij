import java.util.*;
class User {
    int id;
    int age;
    String name;
    public User(String name,int id, int age) { //생성자
        this.id = id;
        this.age = age;
        this.name=name;
    }

}
public class CollectionTest {
    public static void show(List<String> list){
        Iterator<String>iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
    }
    public static void main(String[] args) {
        List<User> userList= new ArrayList<>();
        userList.add(new User("유재석",1,20));
        userList.add(new User("박명수",2,50));
        userList.add(new User("정준하",3,40));
        userList.add(new User("정준하",4,45));
        userList.add(new User("정준하",5,17));
        Collections.sort(userList, new Comparator<User>() { // 객체를 정렬하려면 Comparator를 재정의해야함.
            @Override
            public int compare(User o1, User o2) {
                /*if(o1.age>o2.age) {
                    return 1; 오름차순
                }else if(o1.age< o2.age){
                    return -1; 내림
                }
                return 0;이렇게 잘안씀.*/
                // return o1.age-o2.age;
//                 return o1.name.charAt(0)-o2.name.charAt(0);
                if(o1.name.equals(o2.name)){
                    return o1.age-o2.age;
                }
                return o1.name.compareTo(o2.name);


            }
        });
        for(User user:userList){
            System.out.println(user.name+"==="+user.id+"==="+user.age);
        }

        // 객체는 일반적인 방법으론 정렬할수없다.
//        List<String> movieList = new ArrayList<>();
//        movieList.add("아이언맨");
//        movieList.add("파묘");
//        movieList.add("어벤져스");
//        movieList.add("가디언즈 오브 갤럭시");
//        show(movieList);
       // Collections.sort(movieList);
//        show(movieList);
//        Collections.sort(movieList,Collections.reverseOrder()); //정렬하기 ㄱㄴ순,오름차순 내림차순정렬가능
//        show(movieList);

    }
}
