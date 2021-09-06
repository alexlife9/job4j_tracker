package ru.job4j.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    private static List<List<Integer>> matrix = List.of(
            List.of(1, 2),
            List.of(3, 4)
    );

    public static void main(String[] args) {
        System.out.println(
                matrix.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList())
        );
    }

    public static List<Integer> convertMatrix(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList()
        );
    }
}
