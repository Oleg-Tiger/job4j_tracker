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
       list = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, fun.apply(list.get(i)));
        }
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> copy = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (fun.test(list.get(i))) {
                copy.add(list.get(i));
            }
        }
        list = copy;
        return this;
    }

    public List<Integer> collect() {
        List<Integer> rsl = new ArrayList<>(list);
        return rsl;
    }
}