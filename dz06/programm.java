package dz06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Подумать над структурой класса Ноутбук для магазина техники — выделить поля и
 * методы. Реализовать в Java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет
 * ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
 * Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объём ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев —
 * сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 */
public class programm {
    public static notebook nt1;
    public static notebook nt2;
    public static notebook nt3;
    public static notebook nt4;
    public static notebook nt5;

    public static void initNotebookList() {
        nt1 = new notebook("16.1'\1920x1080", "IPS", "Honor MagicBook 16", "AMD Ryzen i5 5600H 3.3 ГГц", 512,
                "HDD", "Windows 10 Pro", 16, "Grey", 1.84, 18.2, 369.0, 48_999.00, 10);

        nt2 = new notebook("1920x1080", "15.6'", "HUAWEI MateBook D15",
                "Honor Intel Core i5 1135G7 2.4 ГГц", 256,
                "SSD", "Windows 11", 16, "Silver", 1.56, 16.9, 357.8, 57_999.00, 3);

        nt3 = new notebook("1920x1080", "15.6'", "Lenovo Legion 5", "Intel Core i5 11400H 2.7 ГГц",
                512,
                "SSD", "Windows 11 Домашняя 64", 16, "Silver", 2.4, 25.75, 363.0, 72_999.00, 5);

        nt4 = new notebook("1920x1080", "15.6'", "ASUS TUF Gaming F15", "Intel Core i5 11400H 2.7 ГГц",
                512,
                "SSD", "Windows 11 Домашняя 64", 8, "Dark Grey", 2.3, 24.3, 359.0, 79_999.00, 2);

        nt5 = new notebook("2520x1680", "16'", "HUAWEI MateBook 16S", "Intel Core i7 12700H 2.4 ГГц",
                1024,
                "SSD", "Windows 11 Домашняя", 16, "Cosmic Grey", 2.3, 24.3, 359.0, 109_999.00, 6);

        // notebook nt6 = new notebook();

        // notebook nt7 = new notebook();

        // notebook nt8 = new notebook();

        // notebook nt9 = new notebook();

        // notebook nt10 = new notebook();

    }

    public static void printMainMenu(String[] options) {
        System.out.println();
        String textMenu = "gB--------Магазин техники####2023---------"
                + "\n-------------------------------------------";
        for (String option : options)
            textMenu += ("\n" + option);
        System.out.println(textMenu);
        System.out.print("Выбери свою опцию: ");
    }

    public static void main(String[] args) {
        String[] options = {
                "1- Просмотр полного справочника\t\t-1-",
                "2- Фильтр в справочнике \t\t-2-",
                "3- Выход \t\t\t\t-3-",
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            initNotebookList();
            ArrayList<notebook> Notebooks = new ArrayList(Arrays.asList(nt1, nt2, nt3, nt4, nt5));
            filterData filter = new filterData();
            printMainMenu(options);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    filter.withoutFilter(Notebooks);
                    break;
                case 2:
                    Map<Integer, String> filtersList = new HashMap();
                    filter.initFilterMenu(filtersList, scanner, Notebooks);
                    break;
            }
        }
    }
}
