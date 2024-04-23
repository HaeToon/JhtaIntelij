import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int age;
    private String dept;
    private int salary;

    public Employee() {}

    public Employee(String name,  int age, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String info = name+", " + age +", "  + dept +", "  + salary;
        return info;
    }
}



public void  main() {
    List<Employee> empList = Arrays.asList(
            new Employee("홍길동", 30, "총무부", 2000000),
            new Employee("일론머스크", 26, "개발부", 3000000),
            new Employee("이순신", 32, "회계부", 3000000),
            new Employee("저커버그", 26, "개발부", 3200000),
            new Employee("유재석", 40, "인사부", 4000000),
            new Employee("손흥민", 26, "개발부", 2400000),
            new Employee("정준하", 28, "회계부", 2700000),
            new Employee("스티브잡스", 26, "개발부", 3400000),
            new Employee("홍박사", 60, "총무부", 4300000)
    );
//    empList.stream().mapToInt(new ToIntFunction<Employee>() {
//        @Override
//        public int applyAsInt(Employee emp) {
//            return emp.getSalary();
//        }
//    });
//    ↓
//    empList.stream().mapToInt( value ->  value.getSalary());
//    ↓
    //제일좋은 방법은 sql
      double avg = empList.stream()
              .mapToInt(Employee::getSalary)
              .average()
              .getAsDouble();
      System.out.println(avg);
//    OptionalDouble optionalDouble = empList.stream()
//            .mapToInt(Employee::getSalary)
//            .average();
//    if(optionalDouble.isPresent()) {
//        optionalDouble.getAsDouble();
//    }else {
//        System.out.println("연산실패");
//    }

    //=========================================3============================================
    List<Employee>empFilterList =
            empList.stream()
                    .filter(employee ->employee.getDept()
                            .equals("회계부"))
                    .collect(Collectors.toList());
    empFilterList.forEach( employee-> System.out.println(employee.getName()));

    //==========================================4==========================================
   Map<String,List<Employee>> groupList = empList.stream()
            .collect(Collectors.groupingBy(Employee::getDept));
    System.out.println();
    groupList.forEach(new BiConsumer<String, List<Employee>>() {
        @Override
        public void accept(String s, List<Employee> employees) {
            System.out.println(s);
            employees.forEach(employee -> System.out.println(employee.getName()));
        }
    });

}