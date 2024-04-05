package Practice01;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyEventListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
        JButton test = (JButton)e.getSource();
        System.out.println(test.getText());
        if(e.getStateChange()==1){
            test.setEnabled(false);
        }else {
            test.setEnabled(true);
        }
    }
}
