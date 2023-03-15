package dz03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */
public class work02 {
    public static ArrayList<Integer> FillArray(ArrayList<Integer> arrList) {
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            arrList.add(random.nextInt(1, 101));
        return arrList;
    }

    public static ArrayList<Integer> DelHonestNums(ArrayList<Integer> arrList) {
        for (int i = arrList.size() - 1; i >= 0; i--) {
            if (arrList.get(i) % 2 == 0)
                arrList.remove(i);
        }
        return arrList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList = FillArray(arrList);
        System.out.println("список до (полный):" + arrList);
        arrList = DelHonestNums(arrList);
        System.out.println("список после (без четных чисел):" + arrList);
    }

}