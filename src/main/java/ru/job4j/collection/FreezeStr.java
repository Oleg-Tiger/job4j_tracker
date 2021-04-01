package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> l = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            if (!l.containsKey(left.charAt(i))) {
                l.put(left.charAt(i), 0);
            }
            l.put(left.charAt(i), l.get(left.charAt(i)) + 1);
        }
        for (int i = 0; i < right.length(); i++) {
            if (!l.containsKey(right.charAt(i))) {
                return false;
            }
            if (l.get(right.charAt(i)) == 1) {
                l.remove(right.charAt(i));
            } else {
                l.put(right.charAt(i), l.get(right.charAt(i)) - 1);
            }
        }
        return l.isEmpty();
    }
}