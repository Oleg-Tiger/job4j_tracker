package ru.job4j.oop.profession;

public class Dentist extends Doctor {

    private String adultOrChild; //Взрослый или детский врач

    public Dentist(String name, String surname, String education, String birthday, int patientsNumber, String adultOrChild) {
        super(name, surname, education, birthday, patientsNumber);
        this.adultOrChild = adultOrChild;
    }

    public String getAdultOrChild() {
        return adultOrChild;
    }

    public void cureATooth(Diagnosis diagnosis) {

    } //вылечить зуб

    public void putASeal() {

    }
    //Поставить пломбу

    public void pullOutATooth() {

    }
    //Выдернуть зуб
}
