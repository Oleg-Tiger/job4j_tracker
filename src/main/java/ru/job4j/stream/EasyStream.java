package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list = new ArrayList<>();

    public static EasyStream of(List<Integer> source) {
        EasyStream eStream = new EasyStream();
        eStream.list.addAll(source);
        return eStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
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