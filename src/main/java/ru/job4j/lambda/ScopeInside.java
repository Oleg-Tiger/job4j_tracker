package ru.job4j.lambda;

import java.util.function.Function;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            total = add(
                    (x) ->  x + num, total
            );
        }
        System.out.println(total);
    }

    private static Integer add(Function<Integer, Integer> calc, int a) {
        return calc.apply(a);
    }
}