package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> l = new HashMap<>();
        Map<Character, Integer> r = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            if (!l.containsKey(left.charAt(i))) {
                l.put(left.charAt(i), 0);
            }
            l.put(left.charAt(i), l.get(left.charAt(i)) + 1);
        }
        for (int i = 0; i < right.length(); i++) {
            if (!r.containsKey(right.charAt(i))) {
                r.put(right.charAt(i), 0);
            }
            r.put(right.charAt(i), r.get(right.charAt(i)) + 1);
        }
        return r.equals(l);
    }
}