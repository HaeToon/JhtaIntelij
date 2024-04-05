import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class TextFieldTest extends JFrame {
    public TextFieldTest() throws HeadlessException {
        this.setTitle("sadawfaf");
        this.setSize(400,400);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
        c.setLayout(new FlowLayout());

        JLabel label01 = new JLabel("id");
        c.add(label01);
        JTextField textField01 = new JTextField(20);
        c.add(textField01);

        JLabel label02 = new JLabel("pw");
        c.add(label02);
        JPasswordField textField02 = new JPasswordField(20);
        c.add(textField02);

        JButton login = new JButton("login");
        c.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //보안상의 문제때문에 .getPassword()가 String을 리턴하지않음.
                //String을 리턴하면 메모리에 값이 Gc가 가져가기전까지 남아있음.

               char password [] = textField02.getPassword();
               char password02 [] = {'1','2','3','4',};
               if(Arrays.equals(password,password02));

//                System.out.println(password);
//                String password02 = new String(textField02.getPassword());
//                if(textField01.getText().equals("gxg4205") && password02.equals("1234")){
//                    System.out.println("로그인");
//                }else {
//                    System.out.println("로그인실패");
//                }
            }
        });



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldTest();
    }
}