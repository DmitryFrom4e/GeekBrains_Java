package dz04;

import java.util.LinkedList;
import java.util.Random;

/**
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернёет «перевёрнутый» список.
 */
public class work01 {
    public static LinkedList<Integer> FillArray(LinkedList<Integer> arrList) {
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            arrList.add(random.nextInt(1, 101));
        return arrList;
    }

    public static LinkedList<Integer> ReverseArray(LinkedList<Integer> arrList) {
        LinkedList<Integer> buffList = new LinkedList<>();
        for (int i = arrList.size() - 1; i >= 0; i--) {
            buffList.add(arrList.get(i));
        }
        return buffList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> arrList = new LinkedList<>();
        arrList = FillArray(arrList);
        System.out.println("входной массив: " + arrList);
        LinkedList<Integer> revList = new LinkedList<>();
        revList = ReverseArray(arrList);
        System.out.println("перевернутый массив: " + revList);
    }
}