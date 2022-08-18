package ru.job4j.implementation;

public class Dentist extends Doctor {

    private String caries;

    public Dentist(String name, String surname, String education, double birthday,
                   String nameHospital, String diagnosis, String caries) {
        super(name, surname, education, birthday, nameHospital);
        this.caries = caries;
    }

    public String getCaries() {
        return caries;
    }
}
