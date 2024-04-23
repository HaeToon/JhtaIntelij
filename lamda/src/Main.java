

class MyMath {
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    class Object {
        int max(int a, int b) {
            return a;
        }
    }

    @FunctionalInterface
    interface MyFunction {
        int max(int a, int b);

//        int min(int a, int b);
    }

    public class Main {
        public static void main(String[] args) {
////        Math math = new MyMath();
//        new Object(){
//            int max(int a , int b){
//                returna a>b a? :b
//            }
            MyFunction myFunction01 = new MyFunction() {
                @Override
                public int max(int a, int b) {
                    return a > b ? a : b;
                }
            };
            int value = myFunction01.max(10, 20);
            System.out.println(value);
            MyFunction myFunction02 = (a, b) -> a > b ? a : b;
            int value02 = myFunction02.max(10, 20);

        }

    }
}

//public static void main(String[] args) {
//    //람다식 (lamda expression)
//    //람다는 간편하게 쓰려고 만든 형식. 쓰다보면 익숙해진다.
//    //메서드에만 존재
//    //자바에서는 함부로 존재불가능.
//
//    public int max ( int a, int b){
//        return a > b ? a : b;
//    }
//
//    (int a, int b) -> {
//        return a > b ? a : b;
//    }
//    (int a, int b) -> return a > b ? a : b;
//    (int a, int b) -> a > b ? a : b;
//    (int a, int b) -> a > b ? a : b
//            (a, b) ->a > b ? a : b
//    int pow ( int a){
//        return a * a;
//    }
//    (int a) -> {
//        return a * a;
//    }
//    (int a) -> return a * a;
//    (a) -> return a * a;
//    (a) -> a * a;
//    (a) -> a * a
//    a -> a * a;
//
//}
//}
