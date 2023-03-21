package dz05.work02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Пусть дан список сотрудников:
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Анастасия Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * Написать программу, которая найдёт и выведет
 * повторяющиеся имена с количеством повторений. Отсортировать по убыванию
 * популярности.
 */
public class programm {

    public static void counting(Map<String, String> people, Map<String, Integer> treeMap) {
        for (var elem : people.entrySet()) {
            if (!treeMap.containsKey(elem.getValue())) {
                treeMap.put(elem.getValue(), 1);
            } else
                treeMap.put(elem.getValue(), treeMap.get(elem.getValue()) + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        getDataFromFle getData = new getDataFromFle();
        HashMap<String, String> hashPeople = new HashMap<>();
        getData.fileRead(hashPeople);
        TreeMap<String, Integer> tm = new TreeMap<>();
        final TreeMap<String, Integer> fm = new TreeMap<>();
        counting(hashPeople, tm);
        System.out.println(tm);
        tm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
        // .forEach((k, b) -> fm.put(k, b));
    }
}