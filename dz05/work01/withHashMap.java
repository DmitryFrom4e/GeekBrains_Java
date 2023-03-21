package dz05.work01;

import java.util.HashMap;
import java.util.Map.Entry;

public class withHashMap {
    public void printHashMap(HashMap<Integer, String> hm) {
        for (Entry<Integer, String> elem : hm.entrySet()) {
            System.out.printf("Ид пользователя: %d, Информация: %s\n", elem.getKey(), elem.getValue());
        }
    }
}
