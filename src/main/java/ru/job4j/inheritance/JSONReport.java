package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
       String one = "{" + System.lineSeparator() + String.format("\"name\" : \"%s\",", name);
       String two = String.format("\"body\" : \"%s\"", body) + System.lineSeparator() + "}";
        return one + System.lineSeparator() + two;
    }
}
