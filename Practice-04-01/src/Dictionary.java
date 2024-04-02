public class Dictionary extends PairMap {
    int count = 0; // 배열이 만들어질때마다 카운트 (배열의 길이 용)

    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
    }

    @Override
    String get(String key) {//get(String key)와 같은값을 갖는 keyArray[i]를 찾아서 value값을 출력.
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return "해당하는 키값이 없습니다.";
    }

    @Override
    void put(String key, String value) { // key값 value값 넣기
        //1.중복이있는지 확인 중복이있으면 밸류값 변경
        int check = 0; //중복체크 용
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) { //중복키값 발견
                valueArray[i] = value;
                check++;
            }
        }
        if (check == 0) { //중복안됨
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        }
    }

    @Override
    String delete(String key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) { //중복키값 발견
                valueArray[i] = null;       //
                keyArray[i] = null;
                count--;
            }
        }
        System.out.println(keyArray[0] + valueArray[0]);
        System.out.println(keyArray[1] + valueArray[1]);
        System.out.println(keyArray[2] + valueArray[2]);
        return null;
    }

    @Override
    int length() {
//        int length=0;
//        for(int i=0; i< keyArray.length;i++) {
//            if(keyArray[i]!=null) {
//                length++;
//            }
//        }
//        return length;
        return count;
    }

}
