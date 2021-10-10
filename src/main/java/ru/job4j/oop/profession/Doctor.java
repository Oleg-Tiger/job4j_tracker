package ru.job4j.oop.profession;

public class Doctor extends Profession {

    private int pacientsNumber;

    public Doctor(String name, String surname, String education, String birthday,
                  int pacientsNumber) {
        super(name, surname, education, birthday);
        this.pacientsNumber = pacientsNumber;
    }

    public int getPacientsNumber() {
        return pacientsNumber;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }

}
