import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice04 extends JFrame {
    private String moneyString[] = {"오만원","만원","오천원","천원","오백원","백원","오십원","십원"};
    private int moneyInt[]={50000,10000,5000,1000,500,100,50,10};
    private JTextField textFieldList [] = new JTextField[moneyInt.length];
    private JCheckBox checkBoxList[] = new JCheckBox[textFieldList.length];
    public Practice04() throws HeadlessException {
        this.setTitle("Practice03");
        this.setSize(400,500);
        Container c = this.getContentPane();
        c.setLayout(null); //Size 와 Location을 잡아줘야 보임.

        JLabel moneyLabel = new JLabel("금액");
        JLabel restLabel = new JLabel("잔액");
        JTextField moneyTxt = new JTextField(30);
        JTextField moneyRest = new JTextField(30);
        JButton change = new JButton("계산");

        moneyLabel.setSize(40,30);
        moneyLabel.setLocation(70,50);
        moneyLabel.setHorizontalAlignment(JLabel.RIGHT);

        moneyTxt.setSize(140,30);
        moneyTxt.setLocation(120,50);

        change.setSize(60,30);
        change.setLocation(270,50);

        restLabel.setSize(40,30);
        restLabel.setLocation(80,348);

        moneyRest.setSize(140,30);
        moneyRest.setLocation(120,350);

        for(int i=0; i<moneyInt.length; i++){
            JLabel label = new JLabel(moneyString[i]);
            label.setSize(50,30);
            label.setLocation(60,90+(i*30));
            label.setHorizontalAlignment(JLabel.RIGHT);
            c.add(label);
            JTextField textField = new JTextField(30);
            textFieldList[i]=textField;
            textFieldList[i].setSize(120,25);
            textFieldList[i].setLocation(130,95+(i*30));
            c.add(textField);
            JCheckBox checkBox = new JCheckBox();
            checkBoxList[i]=checkBox;
            checkBoxList[i].setSize(20,20);
            checkBoxList[i].setLocation(280,97+(i*30));
            c.add(checkBox);
        }

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int money = Integer.parseInt(moneyTxt.getText());
                int rest =0;

                for(int i=0; i<moneyInt.length; i++){
                    if(!checkBoxList[i].isSelected()){
                        textFieldList[i].setText("0");
                        continue;
                    }
                    rest=money/moneyInt[i];
                    textFieldList[i].setText(Integer.toString(rest));
                    money=money%moneyInt[i];
                }
            }
        });

        c.add(moneyLabel);
        c.add(moneyTxt);
        c.add(change);
        c.add(restLabel);
        c.add(moneyRest);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice04();
    }
}
