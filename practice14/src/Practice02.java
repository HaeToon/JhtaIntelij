import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Practice02 {
    private String name;
    private int age;
    private String dept;
    private int salary;

    public Practice02() {}

    public Practice02(String name,  int age, String dept, int salary) {
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

List<Practice02> empList = Arrays.asList(
        new Practice02("홍길동", 30, "총무부", 2000000),
        new Practice02("이순신", 32, "회계부", 3000000),
        new Practice02("유재석", 40, "인사부", 4000000),
        new Practice02("손흥민", 26, "개발부", 2400000),
        new Practice02("정준하", 28, "회계부", 2700000)
);

public void main() {

   Set<Practice02>practice02 = empList.stream().collect(Collectors.toSet());

    System.out.println(practice02.stream().count());
}

