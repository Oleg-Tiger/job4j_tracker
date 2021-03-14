package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student oleg = new Student();
        oleg.setFullName("Ershov Oleg Igorevich");
        oleg.setGroupNumber("job4j - intern");
        oleg.setDateOfAdmission(LocalDate.of(2021, 2, 24));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String name = "FullName: " + oleg.getFullName();
        String group = "Group №: " + oleg.getGroupNumber();
        String date = "Date of admission: " + oleg.getDateOfAdmission().format(formatter);
        System.out.println(name + System.lineSeparator() + group + System.lineSeparator() + date);
    }
}
