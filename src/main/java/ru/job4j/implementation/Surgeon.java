package ru.job4j.implementation;

public class Surgeon extends Doctor {

    private String fracture; //перелом
    private int numberOfStitches; //кол-во швов

    public Surgeon(String name, String surname, String education, double birthday, String nameHospital, String diagnosis, String fracture, int numberOfStitches) {
        super(name, surname, education, birthday, nameHospital, diagnosis);
        this.fracture = fracture;
        this.numberOfStitches = numberOfStitches;
    }

    public String getFracture() {
        return fracture;
    }

    public int getNumberOfStitches() {
        return numberOfStitches;
    }
}
