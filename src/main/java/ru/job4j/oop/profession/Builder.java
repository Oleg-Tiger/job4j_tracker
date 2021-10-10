package ru.job4j.oop.profession;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, String birthday, int experience) {
        super(name, surname, education, birthday, experience);
    }

    public Estimate makeAnEstimate() {
        return new Estimate();
    }
}
