package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            rsl.add(fun.apply(list.get(i)));
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (fun.test(list.get(i))) {
                rsl.add(list.get(i));
            }
        }
       return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return new ArrayList<>(list);
    }
}