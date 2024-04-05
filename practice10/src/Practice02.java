import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Practice02 extends JFrame {

    int i=0;
    public Practice02() throws HeadlessException {
        this.setTitle("JComboBox Practice02");
        this.setSize(250,300);



        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        JTextField textField = new JTextField(10);
        JComboBox comboBox = new JComboBox();

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    System.out.println(textField.getText());
                    comboBox.addItem(textField.getText());
                }
            }
        });
        c.add(textField);
        c.add(comboBox);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
