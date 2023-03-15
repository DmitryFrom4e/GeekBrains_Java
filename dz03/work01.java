package dz03;

import java.util.Arrays;

/**
 * Реализовать алгоритм сортировки слиянием
 */
public class work01 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 12, 3, 5, 23, 632, 4, 5, 67, 66, 55, 74, 12, 89, 6, 9, 8, 7, 18, 91, 2, 77, 14 };
        int[] arr = array;
        if (array.length > 2)
            array = Sorted_merge.sortArray(array);

        System.out.println("Start");
        System.out.println(Arrays.toString(arr));

        System.out.println();
        System.out.println("Finish");
        System.out.println(Arrays.toString(array));

    }

    public interface Sorted_merge {
        public static int[] sortArray(int[] array) {
            if (array == null || array.length < 2)
                return array;

            int length_arr = array.length / 2;

            if (array.length % 2 != 0)
                length_arr++;

            int[] arrayR = new int[length_arr];
            int[] arrayL = new int[array.length / 2];

            for (int i = 0; i < array.length / 2; i++)
                arrayL[i] = array[i];

            for (int i = array.length / 2; i < array.length; i++)
                arrayR[i - array.length / 2] = array[i];

            arrayL = sortArray(arrayL);
            arrayR = sortArray(arrayR);

            return mergeArray(arrayL, arrayR);
        }

        public static int[] mergeArray(int[] arrayL, int[] arrayR) {

            int[] arrayC = new int[arrayL.length + arrayR.length];
            int posL = 0, posR = 0;

            for (int i = 0; i < arrayC.length; i++) {
                if (posL < arrayL.length && posR < arrayR.length) {
                    if (arrayL[posL] < arrayR[posR]) {
                        arrayC[i] = arrayL[posL];
                        posL++;
                    } else {
                        arrayC[i] = arrayR[posR];
                        posR++;
                    }
                } else if (posL == arrayL.length && posR < arrayR.length) {
                    arrayC[i] = arrayR[posR];
                    posR++;
                } else if (posL < arrayL.length && posR == arrayR.length) {
                    arrayC[i] = arrayL[posL];
                    posL++;
                } else {
                    arrayC[i] = 0;
                }
            }
            return arrayC;
        }
    }
}
