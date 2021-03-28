package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("free_person@inbox.ru", "Ershov Oleg");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
