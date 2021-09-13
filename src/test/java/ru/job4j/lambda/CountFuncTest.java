package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountFuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountFunc.diapason(1, 4, x -> 2 * x + 1);
        List<Double> expected = List.of(3D, 5D, 7D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = CountFunc.diapason(1, 4, x -> x * x + 3);
        List<Double> expected = List.of(4D, 7D, 12D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = CountFunc.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = List.of(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}
