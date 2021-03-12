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
        String date = oleg.getDateOfAdmission().format(formatter);
        String name = oleg.getFullName();
        String group = oleg.getGroupNumber();
        System.out.println(String.format("FullName: %s\nGroup №: %s\nDate of admission: %s", name, group, date));

    }
}
