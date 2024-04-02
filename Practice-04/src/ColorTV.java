public class ColorTV extends TV {
    private int color;
    ColorTV(int size , int color) {
        super(size);
        this.color = color;
    }
    public int getColor() {
        return color;
    }
    void printProperty() {
        System.out.println(getSize() + "인치" + getColor() + "컬러");
    }
}
