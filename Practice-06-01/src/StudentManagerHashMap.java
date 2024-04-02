import java.util.*;

public class StudentManagerHashMap {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Student> students = new HashMap<String, Student>();

    //외부로 부터 입력받아서 학생정보 입력
    private void read() {
        System.out.println("학생정보를 입력해 주세요.[이름,학과,id,학점평균]");
        for (int i = 0; i < 4; i++) {
            System.out.println("입력시작>>");
            String str = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(str, ",");
//            while(st.hasMoreTokens()){
//                System.out.println(st.nextToken());
//            }
            String name = st.nextToken();
            String department = st.nextToken();
            int id = Integer.parseInt(st.nextToken()); // Integer.parseInt(문자열) 문자열을 integear로바꿈
            double grade = Double.parseDouble(st.nextToken());// Double.parseInt(문자열) 문자열을 double로바꿈
            Student student = new Student(name, department, id, grade);
            students.put(name,student);
        }
    }

    public void showAll() {
        Set<String> keyList = students.keySet();
        Iterator<String>iterator=keyList.iterator();
        while(iterator.hasNext()){
            String selectedName=iterator.next();
            Student student=students.get(selectedName);
            String name = student.getName();
            String department = student.getDepartment();
            int id=student.getId();
            double grade=student.getGrade();
            System.out.println("--------------------------------------------");
           System.out.printf("이름 : %s 학과 : %s  학번 : %d  학점 : %.2f", name, department, id, grade);
            System.out.println();
        }
    }

    public void query() {
        while (true) {
            System.out.println("검색할 학생이름을 입력해주세요");
            String name = scanner.nextLine();
            if (name.equals("그만")) break;
            Student student = students.get(name);
//            boolean isSearch = false;
//            for (int i = 0; i < students.size(); i++) {
                if (student!=null) {
//                    isSearch = true;
                    String searchName = student.getName();
                    String department = student.getDepartment();
                    int id = student.getId();
                    double grade = student.getGrade();
                    System.out.printf("이름 : %s 학과 : %s  학번 : %d  학점 : %.2f", searchName, department, id, grade);
                    System.out.println();
                }else {
                    System.out.println(name + "은 없습니다.");
                }
//            }
//            if (isSearch == false) {
//                System.out.println(name + "은 없습니다.");
//            }
        }
    }

    public void run() {
        read();
        showAll();
        query();
    }
}
