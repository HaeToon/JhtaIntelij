public class Ball01 {
    private int x , y ,radius,speedX,speedY;
private int life =3;
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public Ball01() {
        System.out.println("생성자");
        this.life=3;
        this.x=0;
        this.y=0;
        this.radius=100;
        this.setSpeedX(5);
        this.setSpeedY(5);
    }

    public Ball01(int x, int y) {
        this(x,y,10);
    }

    public Ball01(int x, int y, int radius) {
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
}
