package ru.job4j.collection;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
