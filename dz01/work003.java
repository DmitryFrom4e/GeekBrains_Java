package dz01;

import java.util.Scanner;

/**
 * Реализовать простой калькулятор
 */
public class work003 {
    private static Double getNumber(Scanner scanner, String message) {
        System.out.print(message);
        double number = scanner.nextDouble();
        return number;
    }

    private static Double Calc(Double a, Double b, char oper) {
        if (oper == '+')
            return a + b;
        if (oper == '-')
            return a - b;
        if (oper == '*')
            return a * b;
        if (oper == '/')
            return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = getNumber(scanner, "Enter first number: ");
        double secondNum = getNumber(scanner, "Enter last number: ");
        System.out.print("\nEnter an operator (+, -, *, /): ");
        var op = scanner.next().charAt(0);
        System.out.printf("Result of operation '" + op + "': " + Calc(firstNum, secondNum, op));
        scanner.close();
    }
}
