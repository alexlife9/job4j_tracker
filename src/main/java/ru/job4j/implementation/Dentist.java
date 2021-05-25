package ru.job4j.implementation;

public class Dentist extends Doctor {

    private String caries; //тип кариеса
    private int badTooth; //номер больного зуба

    public Dentist(String name, String surname, String education, double birthday, String nameHospital, String diagnosis, String caries, int badTooth) {
        super(name, surname, education, birthday, nameHospital, diagnosis);
        this.caries = caries;
        this.badTooth = badTooth;
    }

    public String getCaries() {
        return caries;
    }

    public int getBadTooth() {
        return badTooth;
    }
}
