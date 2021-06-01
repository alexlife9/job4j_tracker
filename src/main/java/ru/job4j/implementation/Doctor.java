package ru.job4j.implementation;

public class Doctor extends Profession {

    private String nameHospital;

    public Doctor(String name, String surname, String education,
                  double birthday, String nameHospital) {
        super(name, surname, education, birthday);
        this.nameHospital = nameHospital;
    }

    public String getNameHospital() {
        return nameHospital;
    }
}
