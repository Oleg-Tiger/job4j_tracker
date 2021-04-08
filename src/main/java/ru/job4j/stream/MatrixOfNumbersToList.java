package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixOfNumbersToList {

    public List<Integer> convertMatrixToList(Integer[][] lists) {
        List<Integer> rsl = Stream.of(lists)
                .flatMap(x -> Stream.of(x))
                .collect(Collectors.toList());
        return rsl;
    }

}
