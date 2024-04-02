public class FruitBoxGeneric<T>{  //<T extends Number>
    private T[] fruit;

    public FruitBoxGeneric(T[] fruit) {
        this.fruit = fruit;
    }
    public T getFruit(int idx){
        return fruit[idx];
    }
    public void method01(){
        // T t = new T(); ==> 생성안됨
    }
//    public static T method02(){ // static을 붙이지못함.
//
//    }

}
