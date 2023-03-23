package dz06;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class filterData {

    public void initFilterMenu(Map<Integer, String> filtersList, Scanner scanner, ArrayList<notebook> Notebooks) {
        System.out.println();
        filtersList.put(1, "Фильтр по модели");
        filtersList.put(2, "Фильтр по оперативной памяти");
        filtersList.put(3, "Фильтр по объему жесткого диска");
        filtersList.put(4, "Фильтр по цвету");
        filtersList.put(5, "Фильтр по процессору");
        filtersList.put(6, "Фильтр по цене");
        filtersList.put(7, "Выход в главное меню");
        for (var elem : filtersList.entrySet())
            System.out.printf("%d - %s\n", elem.getKey(), elem.getValue());
        System.out.print("Выбери свой вариант фильтрации: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == filtersList.size())
            return;
        switch (choice) {
            case 1:
                System.out.print("Введите название модели: ");
                String modelFilter = scanner.nextLine();
                filterByModel(modelFilter, Notebooks);
                break;
            case 2:
                System.out.print("Введите минимальное кол-во оперативной памяти: ");
                Integer ramFilterMin = scanner.nextInt();
                System.out.print("Введите максимальное кол-во оперативной памяти: ");
                Integer ramFilterMax = scanner.nextInt();
                filterByRam(ramFilterMin, ramFilterMax, Notebooks);
                break;
            case 3:
                System.out.print("Введите минимальный объем жесткого диска: ");
                Integer hardFilterMin = scanner.nextInt();
                System.out.print("Введите максимальный объем жесткого диска: ");
                Integer hardFilterMax = scanner.nextInt();
                filterByHdd(hardFilterMin, hardFilterMax, Notebooks);
                break;
            case 4:
                System.out.print("Введите нужный вам цвет: ");
                String colorFilter = scanner.nextLine();
                filterByColor(colorFilter, Notebooks);
                break;
            case 5:
                System.out.print("Введите информацию по процессору: ");
                String processorFilter = scanner.nextLine();
                filterByProcessor(processorFilter, Notebooks);
                break;
            case 6:
                System.out.print("Введите минимальную стоимость: ");
                Double priceFilterMin = scanner.nextDouble();
                System.out.print("Введите максимальный объем жесткого диска: ");
                Double priceFilterMax = scanner.nextDouble();
                filterByPrice(priceFilterMin, priceFilterMax, Notebooks);
                break;
            default:
                break;
        }
    }

    public void withoutFilter(ArrayList<notebook> Notebooks) {
        System.out.println("Полный каталог:");
        for (var elem : Notebooks)
            System.out.println(elem.toString());
    }

    public void filterByModel(String modelFilter, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out.println("Фильтр по модели: " + modelFilter + ":");
        for (var elem : Notebooks)
            if (elem.Model.equals(modelFilter) || elem.Model.indexOf(modelFilter) != -1)
                System.out.println(elem.toString());
    }

    public void filterByRam(Integer ramFilterMin, Integer ramFilterMax, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out.println("Фильтр по оперативной памяти: от " + ramFilterMin + "Гб до " + ramFilterMax + "Гб");
        for (var elem : Notebooks)
            if (elem.Ram >= ramFilterMin && elem.Ram <= ramFilterMax)
                System.out.println(elem.toString());
    }

    public void filterByHdd(Integer hardFilterMin, Integer hardFilterMax, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out.println("Фильтр по объему жесткого диска: от " + hardFilterMin + "Гб до " + hardFilterMax + "Гб");
        for (var elem : Notebooks)
            if (elem.Hard >= hardFilterMin && elem.Hard <= hardFilterMax)
                System.out.println(elem.toString());
    }

    public void filterByColor(String colorFilter, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out.println("Фильтр по цвету: " + colorFilter + ":");
        for (var elem : Notebooks) {
            if (elem.Color.toLowerCase().equals(colorFilter)
                    || elem.Color.toLowerCase().indexOf(colorFilter.toLowerCase()) != -1)
                System.out.println(elem.toString());
        }

    public void filterByProcessor(String processorFilter, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out.println("Фильтр по процессору: " + processorFilter + ":");
        for (var elem : Notebooks)
            if (elem.Processor.toLowerCase().equals(processorFilter)
                    || elem.Processor.toLowerCase().indexOf(processorFilter.toLowerCase()) != -1)
                System.out.println(elem.toString());
    }

    public void filterByPrice(Double priceFilterMin, Double priceFilterMax, ArrayList<notebook> Notebooks) {
        System.out.println();
        System.out
                .println("Фильтр по оперативной памяти:  от " + priceFilterMin + "руб. до " + priceFilterMax + "руб.");
        for (var elem : Notebooks)
            if (elem.Price >= priceFilterMin && elem.Price <= priceFilterMax)
                System.out.println(elem.toString());
    }
}
