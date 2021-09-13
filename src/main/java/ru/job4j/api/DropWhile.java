package ru.job4j.api;

import java.util.List;

public class DropWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .dropWhile(v -> v <= 2)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
