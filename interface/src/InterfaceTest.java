public class InterfaceTest {
    public static void main(String[] args) {
        PolaBear polaBear = new PolaBear();
        polaBear.swim();
                            //좌측 = 규격 우측=규격에 해당하는것
        Huntable hunter01 = new Cat(); //능력(interface)를 가진 것을 묶을수있음
        Huntable hunter02 = new PolaBear();
        Huntable hunter03 = new Eagle();
                             //좌측 = 규격 우측=규격에 해당하는것
        Swimmable swimmable01 = new Turtle();
        Swimmable swimmable02 = new Penguin();
        Swimmable swimmable03 = new PolaBear();
        PolaBear polaBearList[]=new PolaBear[2];
        Huntable hunterList01[]=new Eagle[2];
        Huntable hunterList02[]=new PolaBear[2];
        Huntable hunterList03[]=new Cat[2];
        Huntable hunterList04[]= {hunter01,hunter02,hunter03};
    }
}
