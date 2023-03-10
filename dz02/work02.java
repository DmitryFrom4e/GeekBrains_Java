package dz02;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.*;
import java.util.logging.SimpleFormatter;

/**
 * 2 . Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class work02 {
    public class Main {
        static void writeToLogger(int[] arrayToLog) throws IOException {
            Logger logger = Logger.getLogger(work02.class.getName());
            FileHandler fh = new FileHandler(
                    "C:\\Users\\dim_o\\Desktop\\GeekBrains\\2022new\\1 четверть\\10 Java семинары\\DZ\\dz02\\log.txt");
            logger.addHandler(fh);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            logger.info(arrayToLog.toString());
        }

        public static void main(String[] args) {
            int[] mas = { 11, 3, 40, 16, 57 };

            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;
                        buf = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = buf;
                    }
                }
                writeToLogger(mas);
            }
            System.out.println(Arrays.toString(mas));
        }
    }
}
