class Apple {}
class Banana {}
class Money{}
public class FruitBoxTest {
    public static void main(String[] args) {
        Apple[] arr01 = {
                new Apple(),
                new Apple(),
                new Apple()
        };
        Money[] arr02 = {
                new Money(),
                new Money(),
                new Money()
        };
        //사과든거
        FruitBox appleBox = new FruitBox(arr01);
        //돈든거
        FruitBox moneyBox = new FruitBox(arr02);

          Money apple01 = (Money)appleBox.getFruit(0); // 타입이 달라서 오류발생하지만 오류검증이 안된다.
          Apple apple02 = (Apple)appleBox.getFruit(0);

        //예전에는 Object를 받아서 썼기때문에 값을 끄집어낼때마다 형변환을 해야하는 불편함이 있었다.
        //Object는  타입을 마음대로 형변화해도 오류검증이 안되어 오류가 나지않는다.
        //Generic은 타입을 보장하기때문에 다른 형변환을하면 오류가 난다.
        //선언단계에서는 일반적인 변수타입<T,K,V,E>등 을쓰고
        //컴파일단계에서 구체화 시킨다.<String>,<Integer>등

        FruitBoxGeneric<Money> fruitBoxGeneric01 = new FruitBoxGeneric<>(arr02); // <Money> 타입을 보장받을수있다.
        Money money01 = (Money)fruitBoxGeneric01.getFruit(0);
        Money money02 = fruitBoxGeneric01.getFruit(0);  //Money타입을 보장받기때문에 형변환하지않아도 된다.
//        Apple money02 = (Apple)fruitBoxGeneric01.getFruit(0);   // 타입이보장된 fruitBoxGeneric01에 Apple타입이 있어서 오류발생



//        FruitBoxGeneric<Apple> boxGeneric = new FruitBoxGeneric<>(arr);
//        Apple apple02 = (Apple)boxGeneric.getFruit(0);
//        Banana banana02 = (Banana)boxGeneric.getFruit(1);




//        System.out.println(box.getFruit(0));
//        System.out.println(box.getFruit(1));
//        System.out.println(box.getFruit(2));

    }
}
