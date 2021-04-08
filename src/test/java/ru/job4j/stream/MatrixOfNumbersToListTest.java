package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixOfNumbersToListTest {

    @Test
    public void testConvertMatrixToList() {
        Integer[][] matrix = {{1, 2, 3}, {6, 5, 4}, {-1, 0, 1}};
        List<Integer> rsl = new MatrixOfNumbersToList().convertMatrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 6, 5, 4, -1, 0, 1);
        assertThat(rsl, is(expected));
    }
}