import java.util.*;

public class ArrayListTest {
    public static void main(String[] args){
//        ArrayList<Integer> arrayList=new ArrayList<Integer>();
//        List<Integer> list=new ArrayList<>(); // 실무에서는 List를 많이 씀. ArrayList 대신Vector도 가능
        String animals [] = {"dog","cat","bear","tiger","panda"};
        List<String> animalList = new ArrayList<String>(Arrays.asList(animals));//배열을 바로 넣진못해서 하는작업. 배열의 목록을 출력하는듯.
        animalList.clear();//animalList의 모든것들 지워버림.
//        System.out.println(animalList.get(0));
        for(int i=0; i<animalList.size();i++) {
            System.out.print(animalList.get(i)+"\t");
        }
        System.out.println();
        for(String animal :animalList){
            System.out.print(animal+"\t");
        }
        System.out.println();
        //iterable (순환하다)
        Iterator<String> iterator = animalList.iterator(); //Iterator
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
//        animalList.stream().forEach(animal->{
//            System.out.print(animal+"\t");
//        });
        //사람이름 4개 arrayList에넣고 제일 긴사람 출력하기.

    }
}
