package ru.job4j.stream;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;

public class ListToMapTest {

    @Test
    public void whenListToMapWithoutDuplicates() {
        Student ivanov = new Student(100, "Ivanov");
        Student petrov = new Student(80, "Petrov");
        List<Student> students = Arrays.asList(petrov, ivanov);
        Map<String, Student> rsl = new ListToMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", ivanov);
        expected.put("Petrov", petrov);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenListToMapWithDuplicatesWithSameScore() {
        Student ivanov = new Student(100, "Ivanov");
        Student petrov = new Student(80, "Petrov");
        Student petrov2 = new Student(80, "Petrov");
        List<Student> students = Arrays.asList(petrov, ivanov, petrov2);
        Map<String, Student> rsl = new ListToMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", ivanov);
        expected.put("Petrov", petrov);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenListToMapWithDuplicatesWithDifferentScore() {
        Student ivanov = new Student(100, "Ivanov");
        Student petrov = new Student(80, "Petrov");
        Student petrov2 = new Student(60, "Petrov");
        List<Student> students = Arrays.asList(petrov, ivanov, petrov2);
        Map<String, Student> rsl = new ListToMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", ivanov);
        expected.put("Petrov", petrov2);
        assertThat(rsl, is(expected));
    }
}