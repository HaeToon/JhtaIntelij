import java.util.*;

class Student {
    private String name, department;
    private int studentNum, average;

    public Student(String name, String department, int studentNum, int average) {
        this.name = name;
        this.department = department;
        this.studentNum = studentNum;
        this.average = average;
    }


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public int getAverage() {
        return average;
    }
}


public class Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 4; i++) {
            System.out.println("학생 이름,학과,학번,학점평균을 순서대로 입력해 주세요 구분");
            String name = sc.next();
            String department = sc.next();
            int studentNum = sc.nextInt();
            int average = sc.nextInt();
            students.add(new Student(name, department, studentNum, average));
        }
        Iterator<Student>studentList=students.iterator();
        while(studentList.hasNext()){
            System.out.println("-------------------------");
            System.out.println("이름=="+studentList.next().getName());
        }
        while(true){
            System.out.println("학생이름>>");
            String search = sc.next();
            if(search.equals("그만")){
                break;
            }
        }



    }
}
