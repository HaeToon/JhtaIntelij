import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Practice07 extends JFrame {
    private JLabel imageLabel = new JLabel();
    private int num =0;
    private List<ImageIcon>images = new ArrayList<>(); // import 필요함. 배열을 쓰지 않는다면
//    private ImageIcon imgArr[] = new ImageIcon[10];

    class RadioPanel extends Panel{

        private JRadioButton left = new JRadioButton("left");
        private JRadioButton right = new JRadioButton("right");

        public RadioPanel() {
            ButtonGroup group = new ButtonGroup();
            group.add(left);
            group.add(right);
            this.add(left);
            this.add(right);
            left.setSelected(true);
        }
        public String isDirection(){
            if(left.isSelected()) {
                System.out.println("left");
                return "left";
            }else {
                System.out.println("right");
                return "right";
            }
        }
    }
    public Practice07() throws HeadlessException {

        this.setTitle("Practice03");
        this.setSize(500,500);
        Container c = this.getContentPane();
        RadioPanel radioPanel = new RadioPanel();

        loadImages("fruits"); //images가 채워짐

//        imgArr [0] = new ImageIcon("fruits/apple.png");
//        imgArr [1] = new ImageIcon("fruits/apricot.png");
//        imgArr [2] = new ImageIcon("fruits/banana.png");
//        imgArr [3] = new ImageIcon("fruits/blueberry.png");
//        imgArr [4] = new ImageIcon("fruits/jackfruit.png");
//        imgArr [5] = new ImageIcon("fruits/mangosteen.png");
//        imgArr [6] = new ImageIcon("fruits/pineapple.png");
//        imgArr [7] = new ImageIcon("fruits/raspberry.png");
//        imgArr [8] = new ImageIcon("fruits/strawberry.png");
//        imgArr [9] = new ImageIcon("fruits/watermelon.png");



        imageLabel.setIcon(images.get(0));
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(radioPanel.isDirection().equals("left")){
                num++;
                }else {
                    num--;
                    if(num==-1){
                        num=images.size()-1;
                    }
                }
                num=num%images.size();
                System.out.println(num);
                imageLabel.setIcon(images.get(num));
            }
        });
        c.add(radioPanel,BorderLayout.NORTH);
        c.add(imageLabel,BorderLayout.CENTER);







        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
private void loadImages(String folderPath){
        File file = new File(folderPath);
        File files[] =file.listFiles();
//        for(int i=0; i<files.length; i++){
//
//        }
    for(File f : files){
        if(f.isFile()){
//            f.getName().lastIndexOf("."); // 확장자명
            ImageIcon imageIcon = new ImageIcon(f.getPath());
            images.add(imageIcon);
        }
    }
}
    public static void main(String[] args) {
        new Practice07();
    }
}
