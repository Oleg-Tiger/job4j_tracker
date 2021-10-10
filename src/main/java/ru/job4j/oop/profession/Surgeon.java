package ru.job4j.oop.profession;

public class Surgeon extends Doctor {

    private boolean doOperation;

   public Surgeon(String name, String surname, String education, String birthday,
                  int patientsNumber, boolean doOperation) {
        super(name, surname, education, birthday, patientsNumber);
        this.doOperation = doOperation;
    }

    public boolean isDoOperation() {
        return doOperation;
    }

        public Recipe writeARecipe(Diagnosis diagnosis) {
        return new Recipe();
    }


}
