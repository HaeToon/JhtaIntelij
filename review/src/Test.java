import java.util.ArrayList;
import java.util.List;

public class Test {
   static void referenceTest(Student student){
        student.age++;
    }

    public static void main(String[] args){
        for(int i=0; i<10; i++){
//            if(i==5) break;
            if(i==5) continue;
            System.out.println(i);
        }
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.print(i+"x"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i=0; i<10; i++){
            for(int k =0; k<10-i; k++)
                System.out.print(" ");
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=10; i>=0; i--){
            for(int k =0; k<10-i; k++)
                System.out.print(" ");
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("==========");
//            String str = sc.nextLine();
//            if(str.equals("그만"))break;
//        }
        String fruits[] = {"apple","banana","berry","pear","melon"};
//        List<String> fruitList = Arrays.asList(fruits);
        List<String> fruitList = new ArrayList<>();
        for(int i=0; i<fruits.length; i++){
            fruitList.add(fruits[i]);
        }
        fruitList.add("orange");

        String convertFruit[] =fruitList.toArray(new String[fruitList.size()]);
        Student students[] = new Student[3];
        students[0]=new Student("허태훈",30);
        students[1]=new Student("허태",20);
        students[2]=new Student("허",10);
        //배열은 primitive 가 아닌 reference다
        System.out.println(students[0].age);
        Student students02[] = students;
        students02[1]=new Student("유재석",40);
        System.out.println(students[1].name);
        Test test = new Test();
        test.referenceTest(students[0]);
        System.out.println(students[0].age);
       referenceTest(students02[0]);
        System.out.println(students02[0].age);

        Student heo = new Student();
        heo.printNum(9);
        //private < default 같은 패키지 <protected + 자식클래스 <public 싹다
        //접근제어자는 필드 class 메서드에 붙여 쓴다.
    }
}
