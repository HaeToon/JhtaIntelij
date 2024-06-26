public class Ball {
    private int x , y ,radius,speedX,speedY;
private int life =3;
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public Ball() {
        System.out.println("생성자");
        this.life=3;
        this.x=0;
        this.y=0;
        this.radius=10;
        this.setSpeedX(2);
        this.setSpeedY(2);
    }

    public Ball(int x, int y) {
        this(x,y,10);
    }

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
    public void moveX(int speedX){
        x+=speedX;
    }
    public void moveY(int speedY){
        y+=speedY;
    }
    public boolean isRightTouched(){
        if(x+radius>=GamePanel01.GAME_WIDTH) {
            System.out.println("오른쪽 닿음");
            return true;
        }
        return false;
//        return x+radius>=GamePanel.GAME_WIDTH;
    }
    public boolean isLeftTouched(){
        if(x<=0) {
            System.out.println("왼쪽 닿음");
            return true;
        }
        return false;
//        return x+radius<=0;
    }
}
