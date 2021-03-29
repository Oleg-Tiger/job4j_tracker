package ru.job4j.oop.profession;

public class Programmer extends Engineer {

    private String programmingLanguage; //на каком языке программирования пишет

    public Programmer(String name, String surname, String education, String birthday,
                      int experience, String programmingLanguage) {
        super(name, surname, education, birthday, experience);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public NewClass writeAClass() {
        return new NewClass();
    }
    // Написать новый класс
}
