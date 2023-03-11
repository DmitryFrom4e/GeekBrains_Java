package dz02;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        // public static void createFile() {
        // try (FileWriter fw = new FileWriter(
        // "C:\\Users\\dim_o\\Desktop\\GeekBrains\\2022new\\1 четверть\\10 Java
        // семинары\\DZ\\dz02\\log.txt")) {
        // fw.flush();
        // fw.close();
        // } catch (IOException e) {
        // System.err.println(e.getMessage());
        // }
        // }

        // public static void writeInfoFile(int[] arrayToWrite) {
        // try (PrintWriter pw = new PrintWriter(
        // "C:\\Users\\dim_o\\Desktop\\GeekBrains\\2022new\\1 четверть\\10 Java
        // семинары\\DZ\\dz02\\log.txt")) {
        // System.out.println(Arrays.toString(arrayToWrite));
        // pw.append(Arrays.toString(arrayToWrite));
        // pw.append("\n");
        // pw.flush();
        // pw.close();
        // } catch (FileNotFoundException e) {
        // System.err.println(e.getMessage());
        // }
        // }

        public static void main(String[] args) throws IOException {
            int[] mas = { 90, 3, 40, 50, 57, 10, 0, 100 };
            boolean isSorted = false;
            int buf;
            FileHandler fh = new FileHandler(
                    "C:\\Users\\dim_o\\Desktop\\GeekBrains\\2022new\\1 четверть\\10 Java семинары\\DZ\\dz02\\log.txt");

            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;
                        buf = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = buf;
                        writeToLogger(mas, fh);
                    }
                }
            }
            System.out.println(Arrays.toString(mas));
        }

        private static void writeToLogger(int[] arrayToLog, FileHandler fh) {
            Logger logger = Logger.getLogger(work02.class.getName());

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.addHandler(fh);

            // logger.log(Level.WARNING, Arrays.toString(arrayToLog));
            logger.info(Arrays.toString(arrayToLog));
        }
    }
}
