import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e);
//        System.out.println(e.getSource()); // Event Source  e.getSource = Event를 받고있는 객체를 알려줌. return type가 object임.
        JButton btn = (JButton)e.getSource(); //Object는 얻어올 정보가 적기때문에 JButton으로 다운캐스팅
        String str = btn.getText();
        if(str.equals("click")){
            btn.setText("clicked");
        }else {
            btn.setText("click");
        }
        System.out.println(btn.getText());
    }
}
