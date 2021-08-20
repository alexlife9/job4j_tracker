package ru.job4j.collection;

import java.util.ArrayList;

public class SimpleTestArrayList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        list.add("test1");
//        list.add("test2");
//        list.add("test3");
//        System.out.print(list.get(1) + ":");
//        list.add(1, "test4");
//        System.out.print(list.get(1) + ":");
//        for (String s : list) {
//            System.out.print(s + ":");
//        }
        String t1 = "test1";
        String t2 = "test2";
        list.add(t1);
        list.add(t2);
        System.out.println(list.size() + " - " + t1 + ":" + t2);
        t1 = "test3";
        System.out.println(list.size() + " - " + t1 + ":" + t2);
        list.remove(t1);
        System.out.println(list.size() + " - " + t1 + ":" + t2);
        list.remove("test1");
        System.out.println(list.size() + " - " + t1 + ":" + t2);
        list.remove("test2");
        System.out.println(list.size() + " - " + t1 + ":" + t2);
    }
}

/*
  Элементы в ArrayList нумеруются начиная с нуля. Поэтому элемент с номером 1 — это test2.
  Следующим действием мы добавляем строку «test4» в ячейку с индексом 1.
  При этом элементы с бо́льшим индексом сдвигаются вправо.
  Вторая часть вывода (test4) показывает, что теперь по индексу 1 извлекается именно test4.
  Далее мы обходим все элементы списка и убеждаемся, что они выводятся именно в порядке добавления.
 */