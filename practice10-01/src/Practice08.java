import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice08 extends JFrame {
    MenuPanel menuPanel = new MenuPanel();
    ResultPanel resultPanel = new ResultPanel();
    private Font font = new Font("맑은 고딕",Font.BOLD,24);
    class ResultPanel extends JPanel {
        private JLabel me = new JLabel("me");
        private JLabel com = new JLabel("com");
        private JLabel result = new JLabel("");
        public ResultPanel() {
            this.add(me);
            this.add(com);
            this.add(result);
            me.setVerticalTextPosition(JLabel.BOTTOM);
            me.setHorizontalTextPosition(JLabel.CENTER);
            com.setVerticalTextPosition(JLabel.BOTTOM);
            com.setHorizontalTextPosition(JLabel.CENTER);
            me.setFont(font);
//        me.setIcon(new ImageIcon("RSP/r.png"));
        }

        public void show(ImageIcon meIcon , ImageIcon comIcon,String resultTxt) {
        me.setIcon(meIcon);
        com.setIcon(comIcon);
        result.setText(resultTxt);
//            me.setIcon(new ImageIcon("RSP/s.png"));
//            com.setIcon(new ImageIcon("RSP/r.png"));

        }
    }
    class MenuPanel extends JPanel {
        private ImageIcon images[] = {
                new ImageIcon("RSP/r.png"),
                new ImageIcon("RSP/s.png"),
                new ImageIcon("RSP/p.png"),
        };
        private int selectNum = 0;
        private JButton btns[] = new JButton[3];
        public MenuPanel() {

            for (int i = 0; i < 3; i++) {
                btns[i] = new JButton(images[i]);
                btns[i].setBorder(null);
                this.add(btns[i]);
                btns[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int com = (int) (Math.random() * 3);
                        System.out.println(com);
                        JButton selectBtn = (JButton) e.getSource();
                        if (
                            com == 0 && selectBtn.getIcon() == images[0] ||
                            com == 1 && selectBtn.getIcon() == images[1] ||
                            com == 2 && selectBtn.getIcon() == images[2]
                        ) {
                            System.out.println("비겼습니다.");

                        } else if (
                                com == 0 && selectBtn.getIcon() == images[2] ||
                                com == 1 && selectBtn.getIcon() == images[0] ||
                                com == 2 && selectBtn.getIcon() == images[1]
                        ) {
                            System.out.println("플레이어가 이겼습니다.");

                        } else {
                            System.out.println("컴퓨터가 이겼습니다.");

                        }
                        resultPanel.show(
                                (ImageIcon)selectBtn.getIcon(),
                                images[com],
                                "sadasw"


                        );
                    }
                });
            }
        }
    }

    public Practice08() throws HeadlessException {

        this.setTitle("Practice08");
        this.setSize(800, 600);

        Container c = this.getContentPane();

        c.add(menuPanel, BorderLayout.NORTH);
        c.add(resultPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice08();
    }
}
