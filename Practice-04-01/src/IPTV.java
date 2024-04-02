public class IPTV extends ColorTV{
private String ip;
public IPTV(String ip,int size,int color){
    super(size,color);
    this.ip=ip;
}
    public void printProperty(){
        System.out.print("나의 IPTV는 "+ip+"주소의 ");
        super.printProperty();
    }

    public static void main(String[] args) {
        IPTV iptv=new IPTV("192.0.0.1",32,1920);
        iptv.printProperty();
    }
}
