package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ааа");
        list.add("а");
        list.add("аа");
        list.add("aaaa");
        System.out.println("До сортировки: " + list);
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
        list.sort(cmpDescSize);
        System.out.println("После сортировки: " + list);

        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
