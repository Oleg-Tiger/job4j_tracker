package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionAndStartGreaterThanEndThenLinearResults() {
        List<Double> result = new FunctionRange().diapason(8, 5, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(17D, 15D, 13D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new FunctionRange().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = new FunctionRange().diapason(1, 4, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResults() {
        List<Double> result = new FunctionRange().diapason(2, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D, 81D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenStartEqualsEnd() {
        List<Double> result = new FunctionRange().diapason(4, 4, x -> x * x + 2 * x + 1);
        assertThat(result.size(), is(0));
    }

}