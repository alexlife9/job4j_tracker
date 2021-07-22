package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task tasks : list) {
            numbers.add(tasks.getNumber());
        }
        return numbers;
    }
}

//есть лист с объектами Таск с состояниями number и description
//в новый лист надо записать уникальные номера задач
//это автоматически делается с помощью добавления номеров в HashSet
//проходим каждую задачу в начальном листе
//и добавляем все найденые номера задач в хешлист numbers с помощью getNumber