package ru.job4j.implementation;

public class Surgeon extends Doctor {

    private String fracture;

    public Surgeon(String name, String surname, String education, double birthday,
                   String nameHospital, String fracture) {
        super(name, surname, education, birthday, nameHospital);
        this.fracture = fracture;
    }

    public String getFracture() {
        return fracture;
    }
}
