import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String pwd;
    private String email;
    public User() {

    }

    public void setData(String id , String pwd , String email){
        this.id=id;
        this.pwd=pwd;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setData("student","1234","student.gmail.com");
        List<User>userList = new ArrayList<>();
        userList.add(user);
        for(int i=0; i<userList.size(); i++){
            System.out.println(userList.get(i).getId()+userList.get(i).getPwd()+userList.get(i).email);
        }
    }
}
