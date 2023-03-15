package dz03;

import java.util.ArrayList;
import java.util.Random;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и
 * среднее из этого списка.
 */
public class work03 {
    public static int Minimum(ArrayList<Integer> arrList) {
        int min = arrList.get(0);
        for (int o : arrList) {
            if (o < min)
                min = o;
        }
        return min;
    }

    public static int Maximum(ArrayList<Integer> arrList) {
        int max = arrList.get(0);
        for (int o : arrList) {
            if (o > max)
                max = o;
        }
        return max;
    }

    public static double Average(ArrayList<Integer> arrList) {
        int summa = 0;
        for (int o : arrList) {
            summa += o;
        }
        return summa / arrList.size();
    }

    public static ArrayList<Integer> FillArray(ArrayList<Integer> arrList) {
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            arrList.add(random.nextInt(1, 101));
        return arrList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList = FillArray(arrList);
        System.out.println("список:" + arrList);
        System.out.println("минимальное значение:" + Minimum(arrList));
        System.out.println("максимальное значение:" + Maximum(arrList));
        System.out.println("ср.арифм. значение:" + Average(arrList));
    }
}
