import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//블럭 충돌 방향설정
//1.블럭의 아랫쪽 타격시 아래로 , 2.블럭의 왼쪽 타격시 왼쪽으로 , 03.블럭의 오른쪽 타격시 오른쪽으로,04.블럭의 위를 타격시 위로
//블럭제거
//

public class GamePanel01 extends JPanel implements Runnable {
    //거리측정하는방법 피타고라스 정리
    static final int BLOCK_WIDTH = 30;
    static final int BLOCK_HEIGHT = 12;
    static final int GARO = 30; //가로 블럭 개수
    static final int SERO = 40; // 세로 블럭 개수
    static final int GAP = 2;
    boolean isLoading = true;
    private int ballSpeedX=(int)(Math.random()*3+2);
    private int ballSpeedY=(int)(Math.random()*3+2);
    private int count=0;
    private int ballSpeed=2;
    private int speed=2;
    private int score;
    private int item;
    private int drugX;
    private int drugY;
int random;
    static final int GAME_WIDTH = BLOCK_WIDTH * GARO + GAP * (GARO - 1); //static은 실행과 동시에 올라옴
    static final int GAME_HIGHT = 800;

    private Ball ball;
    private Paddle paddle;
    private Color arr[] = {Color.red, Color.blue, Color.orange, Color.pink, Color.magenta, Color.green, Color.yellow, Color.cyan};
    public BlockGame blocks[][] = new BlockGame[SERO][GARO]; //세로 = 줄 가로 = 블럭개수

    private ImageIcon imageIcon = new ImageIcon("image/heart2.png");
    private Image image = imageIcon.getImage();
    Drug drug= null;

    Thread thread;
    private int life = 3;
    private boolean isStart = false;

    public GamePanel01() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HIGHT)); //사이즈 정확하게 정하는것setPreferredSize(new Dimension(width,height))
        this.setBackground(Color.black);
        paddle = new Paddle(550, 750, 100, 20);
        ball = new Ball();
        ball.setX(paddle.getX()+paddle.getWidth()/2-ball.getRadius()/2);
        ball.setY(paddle.getY()-ball.getRadius());
        for (int i = 0; i < SERO; i++) {
            for (int j = 0; j < GARO; j++) {
                blocks[i][j] = new BlockGame();
                blocks[i][j].setX((BLOCK_WIDTH + GAP) * i);
                blocks[i][j].setY(((BLOCK_HEIGHT + GAP) * j) + 70);
                blocks[i][j].setWidth(BLOCK_WIDTH);
                blocks[i][j].setHeight(BLOCK_HEIGHT);
                blocks[i][j].setColor(arr[j % arr.length]); // i = 줄단위로 컬러변경 j= 칸단위로 컬러 변경
                blocks[i][j].setPoint(5 * i + 5);
            }
        }

//        thread = new Thread(this);
//        thread.start();
//        ball.setSpeedX(2);
//        ball.setSpeedY(-2);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {//누르고있는동안
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.setLeft(true);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.setRight(true);
                }else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("엔터");
                    isLoading=false;
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.setSpeedX(0);
                    paddle.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.setSpeedX(0);
                    paddle.setRight(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("SPACE");
                    if (!isStart) {
                        count=0;
                        ballSpeed=2;

                        ball.setSpeedX(ballSpeed);
                        ball.setSpeedY(-ballSpeed);
                        thread = new Thread(GamePanel01.this);
                        thread.start();
                        isStart = true;
                    }
                    if (life == 0) {
                        life = 3;
                    }
                }
            }
        });
    }
public void drawHeart(Graphics g){
    for (int i = 0; i < life; i++) {
        g.drawImage(image, 20 + (60 * i), 15, this);
    }
}
private void drawLoading(Graphics g){
        //enter 게임시작
    //좌우키 패들 움직이기
    //ball start 는 스페이스키
    g.setColor(Color.black);
    g.fillRect(0,0,GAME_WIDTH,GAME_HIGHT);
    g.setColor(Color.white);
    String title = "BLOCK BREAKER";
    Font font = new Font("맑은고딕",Font.BOLD,48);
    g.setFont(font);
    FontMetrics fontMetrics = g.getFontMetrics();
    int centerX = (GAME_WIDTH - fontMetrics.stringWidth(title))/2;
    g.setFont(new Font("맑은고딕",Font.BOLD,48));
    g.drawString(title,centerX,200);
    String guide01 = "Press Enter GameStart";
    String guide02 = "Left Right Move Paddle";
    String guide03 = "Press Space Ball Start";
    int guideX=(GAME_WIDTH-fontMetrics.stringWidth(guide01))/2;
    g.drawString( guide01,guideX,GAME_HIGHT/2);
    g.drawString( guide02,guideX,GAME_HIGHT/2+100);
    g.drawString( guide03,guideX,GAME_HIGHT/2+200);
}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티알리아싱 으로 좀더 부드럽게 처리
        if(isLoading){

        }
        g.setColor(Color.white);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        g.drawString("점수 : "+Integer.toString(score), 300, 40);
        g.drawString("속도 단계 : "+(speed-2), 500, 40);
        g.drawString("속도 업까지 남은 수 : "+(40-count), 700, 40);
        for (int i = 0; i < SERO; i++) {
            for (int j = 0; j < GARO; j++) {
                if (blocks[i][j].isTouched()) {
                    continue;
                } else {
                    g.setColor(blocks[i][j].getColor());
//            g.setColor(arr[j%arr.length]);
                    g.fillRect(blocks[i][j].getX(), blocks[i][j].getY(), blocks[i][j].getWidth(), blocks[i][j].getHeight());
                }
            }
        }
        drawHeart(g);
        drawDrug(g);
        if(isLoading){
            drawLoading(g);
        }
    }

    private void drawDrug(Graphics g) {
        if(drug!=null) {
            g.drawImage(drug.getImage(), drugX, drugY, this);
        }
    }

    private void moveBall() {
        //이동을 메서드로 만들수있음.
//        ball.setX(ball.getX() + ball.getSpeedX()); //x축이동
        ball.moveX(ball.getSpeedX()); //ball 클래스에 moveLeft 메서드를 만들어서 조금더 간단하게 만듬.
//        ball.setY(ball.getY() + ball.getSpeedY()); //y축이동
        ball.moveY(ball.getSpeedY());//ball 클래스에 moveRight 메서드를 만들어서 조금더 간단하게 만듬.

        if (ball.isRightTouched()) { //x축 튕기기
            ball.setX(GAME_WIDTH-ball.getRadius());
            ball.setSpeedX(-ball.getSpeedX());
        } else if (ball.isLeftTouched()) {
            ball.setX(0);
            ball.setSpeedX(-ball.getSpeedX());
        }

        if (ball.getY() >= GAME_HIGHT + 50 - ball.getRadius()) { //y축 바닥 닿을시
            speed=2;
            thread.interrupt();
            ball.setX(paddle.getX() + paddle.getWidth() / 2);
            ball.setY(paddle.getY() - ball.getRadius());
            isStart = false;
            life--;
        } else if (ball.getY() <= 0) { //꼭대기에 닿았을때
            ball.setY(0);
            ball.setSpeedY(-ball.getSpeedY());
        }
        checkPaddle();
        if(count/40==1){
            count=0;
            ballSpeed++;
            speed++;
            ball.setSpeedX(speed);
            ball.setSpeedY(speed);
        }
    }

    private void checkPaddle() {
        if (ball.getSpeedX() > 0) {
            if ( //paddle 충돌 //오른쪽으로 내려오다가 paddle의 왼쪽절반에 닿았을때
                    hitObject(new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                            new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth() / 2, paddle.getHeight()))) {
                System.out.println("패들왼쪽충돌");
                ball.setSpeedX(-ball.getSpeedX());
                ball.setSpeedY(-ball.getSpeedY());

            }
            if (hitObject(
                    new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                    new Rectangle(paddle.getX() + paddle.getWidth() / 2, paddle.getY(), paddle.getWidth() / 2, paddle.getHeight())
            )) {
                System.out.println("패들왼쪽충돌");
                ball.setSpeedY(-ball.getSpeedY());
            }
        } else if (ball.getSpeedX() < 0) {
            if ( //paddle 충돌  //오른쪽으로 내려오다가 paddle의 오른쪽절반에 닿았을때
                    hitObject(new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                            new Rectangle(paddle.getX() + paddle.getWidth() / 2, paddle.getY(), paddle.getWidth() / 2, paddle.getHeight()))) {
                System.out.println("패들오른쪽충돌");
                ball.setSpeedX(-ball.getSpeedX());
                ball.setSpeedY(-ball.getSpeedY());
            }
            if (hitObject(
                    new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                    new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth() / 2, paddle.getHeight())
            )) {
                System.out.println("패들오른쪽충돌");
                ball.setSpeedY(-ball.getSpeedY());
            }
        }
        if(drug!=null &&hitObject(
                new Rectangle(drug.getX(),drug.getY(),drug.getWidth(),drug.getHeight()),
                new Rectangle(paddle.getX(),paddle.getY(),paddle.getWidth(),paddle.getHeight()))){
            System.out.println("drug 충돌");
        }
    }

    private void checkBlock() {
        for (int i = 0; i < SERO; i++) {
            for (int j = 0; j < GARO; j++) {
                BlockGame block = blocks[i][j];
                if (!block.isTouched()) {  // 보여질때만  충돌감지하기...
                    if (ball.getSpeedY() < 0) {
                        if (
                                hitObject(
                                        new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                                        new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))
                        ) {
                            block.setTouched(true);
                            ball.setSpeedY(-ball.getSpeedY());
                            count++;
                            score+=block.getPoint();
                            System.out.println("하단터치");

                            if(drug==null && Math.random()<0.1){
                                drug = new Drug(drugX,drugY,new ImageIcon("image/drug.png"));
                                drugX= block.getX()+ block.getWidth()/2-12;
                                drugY= block.getY();
                                System.out.println("drug width , height =="+drug.getWidth()+"  "+drug.getHeight());
                            }

                        }
                    } else  if (ball.getSpeedY() > 0) {
                        if (
                                hitObject(
                                        new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                                        new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))
                        ) {
                            block.setTouched(true);
                            ball.setSpeedY(-ball.getSpeedY());
                            random=(int)(Math.random()*10+1);
                            count++;
                            score+=block.getPoint();
                            System.out.println("상단터치");


                            if(drug==null && Math.random()<0.1){
                                drug = new Drug(drugX,drugY,new ImageIcon("image/drug.png"));
                                drugX= block.getX()+ block.getWidth()/2-12;
                                drugY= block.getY();
                            }
                        }

                    } else if (ball.getSpeedX() > 0) { //위로 가면서 오른쪽으로 충돌
                        if (
                                hitObject(
                                        new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                                        new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))
                        ) {
                            block.setTouched(true);
                            score+=block.getPoint();
                            random=(int)(Math.random()*10+1);
                            count++;
                            System.out.println("좌측 터치");


                            if(drug==null && Math.random()<0.1){
                                drug = new Drug(drugX,drugY,new ImageIcon("image/drug.png"));
                                drugX= block.getX()+ block.getWidth()/2-12;
                                drugY= block.getY();
                            }
                            if (ball.getSpeedY() < 0) {
                                ball.setSpeedY(-ball.getSpeedY());
                            } else {
                                if (ball.getSpeedY() > 0) {
                                    ball.setSpeedY(-ball.getSpeedY());
                                }
                            }
                        }
                    } else if (ball.getSpeedX() < 0) { // 왼쪽으로 가면서 위로 충돌
                        if (
                                hitObject(
                                        new Rectangle(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()),
                                        new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))
                        ) {

                            block.setTouched(true);
                            count++;
                            score+=block.getPoint();
                            System.out.println("우측터치");


                            if(drug==null && Math.random()<0.1){
                                drug = new Drug(drugX,drugY,new ImageIcon("image/drug.png"));
                                drugX= block.getX()+ block.getWidth()/2-12;
                                drugY= block.getY();
                            }
                            if (ball.getSpeedY() < 0) {
                                ball.setSpeedY(-ball.getSpeedY());
                            } else {
                                if (ball.getSpeedY() > 0) {
                                    ball.setSpeedY(-ball.getSpeedY());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void movePaddle() {
        paddle.setX(paddle.getX() + paddle.getSpeedX());
        if (paddle.isLeft()) {
            paddle.setSpeedX(-10);
        }
        if (paddle.isRight()) {
            paddle.setSpeedX(10);
        }
        if (paddle.getX() >= GAME_WIDTH - paddle.getWidth()) {
            System.out.println("오른쪽끝");
            paddle.setX(GAME_WIDTH - paddle.getWidth() - 1);
        }
        if (paddle.getX() <= 0) {
            System.out.println("왼쪽끝");
            paddle.setX(1);
        }

    }

    @Override
    public void run() {
        while (true) {
            moveBall();
            movePaddle();
            moveDrug();
            checkBlock();
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                return;
            }
        }
    }

    private void moveDrug() {
        if(drug!=null) {
            drugY += 2;
            System.out.print("drugX ===" +drugX);
            System.out.print("drugY ===" +drugY);
            System.out.print("drugwidth ===" +drug.getWidth());
            System.out.print("drugheight ===" +drug.getHeight());
            System.out.println();
            System.out.print("paddle x ==="+paddle.getX());
            System.out.print("paddle y ==="+paddle.getY());
            System.out.print("paddle width ==="+paddle.getWidth());
            System.out.print("paddle height ==="+paddle.getHeight());
            if (drugY > GAME_HIGHT + 50) {
                System.out.println("drug 떨어짐");
                drug = null;
            }
        }
    }

    //Rectangle 은 x,y,width,height가 있어야함.
    private boolean hitObject(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02); //rect01과 rect02가 겹친다면 true 리턴
    }
}
