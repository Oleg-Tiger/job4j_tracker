package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public Map<String, Student> convertListToMap(List<Student> students) {
        Map<String, Student> rsl = students.stream()
                .collect(Collectors.toMap(
                        x -> x.getSurname(),
                        x -> x,
                        (a, b) -> b
                ));
        return rsl;
    }
}
