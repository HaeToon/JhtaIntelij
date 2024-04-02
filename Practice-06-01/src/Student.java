public class Student {
    // 속성
    private String name;
    private String department;
    private int id;
    private double grade;
    //생성자
    public Student(String name, String department, int id, double grade) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.grade = grade;
    }
    public Student(String name,double grade) { // 7번문제용
        this.name = name;
        this.grade = grade;
    }
    //getter setter등
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }
    //Override


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", id=" + id +
                ", grade=" + grade +
                '}';
    }
}
