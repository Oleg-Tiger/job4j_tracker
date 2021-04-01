package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        origin = origin.replaceAll("\\p{P}", "");
        line = line.replaceAll("\\p{P}", "");
        Set<String> orig = new HashSet<>();
        for (String str : origin.split(" ")) {
            orig.add(str);
        }
        for (String str : line.split(" ")) {
            if (!orig.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
