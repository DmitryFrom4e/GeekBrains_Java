package dz04;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
public class work03 {
    public static double firstNum;
    public static double secondNum;
    public static double result;
    public static char operation;
    public static boolean cancelling;

    private static void initValues(Scanner scanner) {

        if (!cancelling)
            firstNum = getNumber(scanner, "Введите первое число: ");
        operation = getOperation(scanner, "Выберите операцию (+, -, *, /): ");
        secondNum = getNumber(scanner, "Введите второе число: ");
        result = getCalculate(firstNum, secondNum, operation);
    }

    private static double getNumber(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    private static char getOperation(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next().charAt(0);
    }

    private static void writeToLogger(FileHandler fh, String status) {
        Logger logger = Logger.getLogger(work03.class.getName());
        StringBuilder builder = new StringBuilder();
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);
        builder.append(status + ": "
                + firstNum + " "
                + operation + " "
                + secondNum + " = "
                + result);
        logger.log(Level.INFO, builder.toString());
    }

    private static void writeLinkedList(LinkedList<String> lnkList) {
        // if (lnkList.size() > 0)
        // lnkList.clear();
        lnkList.addLast(String.valueOf(firstNum));
        lnkList.addLast(String.valueOf(operation));
        lnkList.addLast(String.valueOf(secondNum));
        lnkList.addLast(String.valueOf(result));
        lnkList.addLast(String.valueOf(";"));
        System.out.println(lnkList);
    }

    private static Double getCalculate(Double a, Double b, Character operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                break;
        }
        return 0.0;
    }

    public static void printMenu(String[] options) {
        System.out.println();
        String textMenu = "gB-----------Калькулятор####2023-----------"
                + "\n-------------------------------------------";
        for (String option : options) {
            textMenu += ("\n" + option);
        }
        System.out.println(textMenu);
        System.out.print("Выбери свою опцию: ");
    }

    public static void menu() throws IOException {
        String[] options = {
                "1- Произвести расчеты \t\t\t-1-",
                "2- Отменить последнюю операцию \t\t-2-",
                "3- Выход \t\t\t\t-4-",
        };
        Scanner scanner = new Scanner(System.in);
        FileHandler fh = new FileHandler("DZ\\dz04\\log.txt", true);
        LinkedList<String> lnkList = new LinkedList<String>();
        int option;
        while (true) {
            cancelling = false;
            printMenu(options);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    initValues(scanner);
                    writeToLogger(fh, "сделано вычисление");
                    writeLinkedList(lnkList);
                    break;
                case 2:
                    if (lnkList.size() == 0) {
                        System.out.println("Нет предыдущих операций для отмены!");
                        break;
                    } else {
                        cancelling = true;
                        writeToLogger(fh, "отменена последняя операция");
                        initValues(scanner);
                        writeLinkedList(lnkList);
                    }
                case 3:
                    System.out.println("Программа завершена пользователем");
                    scanner.close();
                    return;
                default:
                    break;
            }
            fh.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        menu();
    }
}
