package dz05.work01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

// import dz05.work01.getDataFromFiles;

public class programm {

    public static void printMenu(String[] options) {
        System.out.println();
        String textMenu = "gB--------Телефонная книга####2023---------"
                + "\n-------------------------------------------";
        for (String option : options) {
            textMenu += ("\n" + option);
        }
        System.out.println(textMenu);
        System.out.print("Выбери свою опцию: ");
    }

    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");
        String[] arrDataIn = new String[] {};
        fileData gDF = new fileData();
        withLoaded wL = new withLoaded();
        HashMap<Integer, String> telBook = new HashMap<>();
        withHashMap wHM = new withHashMap();
        String[] options = {
                "1- Просмотр справочника \t\t-1-",
                "2- Отменить последнюю операцию \t\t-2-",
                "3- Выход \t\t\t\t-3-",
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu(options);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    arrDataIn = gDF.fileRead();
                    wL.reOrganize(arrDataIn, telBook);
                    wHM.printHashMap(telBook);
                    break;
                case 3:
                    System.out.println("Программа завершена пользователем");
                    scanner.close();
                    return;
            }
        }

    }
}
