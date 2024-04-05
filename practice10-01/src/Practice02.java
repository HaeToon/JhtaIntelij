import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Practice02 extends JFrame {
    public Practice02() throws HeadlessException {
        this.setTitle("Combobox Practice02");
        this.setSize(400,300);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        JTextField textField = new JTextField(15);
        JComboBox comboBox = new JComboBox();

//        textField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_ENTER){
//                    comboBox.addItem(textField.getText());
//                    textField.setText("");
//                }
//            }
//        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textField.getText();
                if(!str.equals("")){
                    comboBox.addItem(textField.getText());
                    textField.setText("");
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
