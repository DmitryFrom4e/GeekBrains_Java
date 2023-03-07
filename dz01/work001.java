package dz01;

import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n),
 * n! (произведение чисел от 1 до n)
 */
public class work001 {

    public static void main(String[] args) {
        long summ = 0;
        long multi = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last number: ");
        int to = scanner.nextInt();
        for (int i = 1; i <= to; i++) {
            summ += i;
            multi *= i;
        }
        System.out.printf("summ: %d", summ);
        System.out.println();
        System.out.printf("multi: %d", multi);
        scanner.close();
    }
}