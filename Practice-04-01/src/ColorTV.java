//class 설계는 코드를 많이 두드려봐야함.
public class ColorTV extends TV{
    private int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color=color;
    }
    public ColorTV(){

    }
    public void printProperty(){
        System.out.print(this.getSize()+"인치, 해상도는 "+this.color);
    }

    public static void main(String[] args) {
        ColorTV coloTV = new ColorTV(32,1920);
        coloTV.printProperty();
    }
}
