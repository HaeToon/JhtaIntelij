import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fruit extends JFrame {
    private String fruits[]= new String[10];// = {"apple","apricot","banana","blueberry","jackfruit","mangosteen","pineapple","raspberry","strawberry","watermelon"};
    int count=1;
    public Fruit() throws HeadlessException {
        fruits[0]="apple";
        fruits[1]="apricot";
        fruits[2]="banana";
        fruits[3]="blueberry";
        fruits[4]="jackfruit";
        fruits[5]="mangosteen";
        fruits[6]="pineapple";
        fruits[7]="raspberry";
        fruits[8]="strawberry";
        fruits[9]="watermelon";

        this.setTitle("Fruits");
        this.setSize(800,600);
        Container c = this.getContentPane(); //여기에 컨퍼넌트 앉히기
//        c.setLayout(new FlowLayout());
        JLabel title = new JLabel("제일 좋아하는 과일은??");
        title.setFont(new Font("맑은 고딕",Font.BOLD,25));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.white);
        JPanel mainPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setBackground(Color.pink);
        rightPanel.setBackground(Color.magenta);

        JLabel leftImageLabel = new JLabel();
        ResizeIcon leftResizeIcon = new ResizeIcon("fruits/"+fruits[0]+".png");
        leftImageLabel.setIcon(leftResizeIcon.getResizedImage(300,300));
        leftPanel.add(leftImageLabel);

        JLabel rightImageLabel = new JLabel();
        ResizeIcon rightResizeIcon = new ResizeIcon("fruits/"+fruits[1]+".png");
        rightImageLabel.setIcon(rightResizeIcon.getResizedImage(300,300));
        rightPanel.add(rightImageLabel);



        c.add(mainPanel,BorderLayout.CENTER);
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        c.setBackground(Color.black);
        c.add(title,BorderLayout.NORTH);
//        c.add(leftPanel,BorderLayout.WEST);
//        c.add(rightPanel,BorderLayout.EAST);



        leftPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                count++;
                System.out.println(count);
                //                if(count==9){
//                    count=0;
//                }
                if(count>fruits.length-2){
                    leftPanel.removeMouseListener(this); // leftPanel이 이벤트를 못받게 제거함.
                    rightPanel.removeMouseListener(this); // leftPanel이 이벤트를 못받게 제거함.
                    rightPanel.setVisible(false);
                }
                System.out.println("왼쪽눌렀음");
                ResizeIcon rightImageIcon = new ResizeIcon("fruits/"+fruits[count]+".png");
                rightImageLabel.setIcon(rightImageIcon.getResizedImage(300,300));
//                Image rightImage = rightImageIcon.getImage();  //Resizeicon클래스를 생성해서 간략화
//                Image rightResizeImage =rightImage.getScaledInstance(300,300,Image.SCALE_SMOOTH);
//                ImageIcon rightImageResizeIcon = new ImageIcon(rightResizeImage);
//                rightImageLabel.setIcon(rightImageResizeIcon);

            }
        });
        rightPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                count++;
                System.out.println(count);
                if(count>fruits.length-2){
//                    leftPanel.removeMouseListener(this); // leftPanel이 이벤트를 못받게 제거함.
                    rightPanel.removeMouseListener(this); // leftPanel이 이벤트를 못받게 제거함.
                    leftPanel.setVisible(false);
                }
//                if(count==9){
//                    count=0;
//                }
                System.out.println("오른쪽눌렀음");
                ResizeIcon leftImageIcon = new ResizeIcon("fruits/"+fruits[count]+".png");
                leftImageLabel.setIcon(leftImageIcon.getResizedImage(300,300));
//                Image leftImage = leftImageIcon.getImage(); //Resizeicon클래스를 생성해서 간략화
//                Image leftResizeImage =leftImage.getScaledInstance(300,300,Image.SCALE_SMOOTH);
//                ImageIcon leftImageResizeIcon = new ImageIcon(leftResizeImage);
//                leftImageLabel.setIcon(leftImageResizeIcon);
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Fruit();
    }
}
