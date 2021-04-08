package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixOfNumbersToList {

    public List<Integer> convertMatrixToList(Integer[][] lists) {
        List<Integer> rsl = Arrays.stream(lists)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
        return rsl;
    }

}
