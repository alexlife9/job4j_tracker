package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
    @Test
    public void whenInteger1to6() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, Matrix.convertMatrix(matrix));
    }
}
