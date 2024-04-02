public class MainTest {
    public static void main(String[] args) { //MobolePhoneInterface라는 규격을 만들어서 여러가지를 만들수있음.
        //유연하게 사용가능함.
        //ex) Connectable
        //    connection();
        // OracleDB oracleDB = new OracleDB();  오라클만 사용가능
        // Connectable oracleDB = new OracleDB();  //Conectable(타입)의 모든것 사용가능
      //  SamsungPhone samsungPhone = new SamsungPhone(); 삼성폰만 사용가능
       // MobilePhoneInterface smartPhone = new LGPhone(); MobilePhoneInterface로 인터페이스를 상속하여 다방면으로 사용가능.
        MobilePhoneInterface smartPhone = new LGPhone();
        smartPhone.sendCall();
        smartPhone.receveCall();
        smartPhone.sendSMS();
        smartPhone.reciveSMS();
    }
}
