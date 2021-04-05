package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> prName = x -> x.getName().contains(key);
        Predicate<Person> prSurname = x -> x.getSurname().contains(key);
        Predicate<Person> prPhone = x -> x.getPhone().contains(key);
        Predicate<Person> prAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = prName.or(prSurname.or(prPhone.or(prAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}