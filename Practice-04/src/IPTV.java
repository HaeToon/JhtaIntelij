public class IPTV extends ColorTV {
    private String ip;
    void printProperty() {
        System.out.println("나의 IPTV는" + ip + "주소의" + getSize() +"인치" + getColor() + "컬러");
    }
    IPTV(String ip , int size, int color) {
        super(size,color);
        this.ip=ip;
    }
}
