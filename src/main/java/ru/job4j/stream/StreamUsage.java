package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, 1, -2, 2, 0, -3, 3));
        List<Integer> rsl = list.stream().filter(
                x -> x > 0
        ).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(rsl);
    }
}
