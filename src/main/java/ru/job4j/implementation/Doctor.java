package ru.job4j.implementation;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private String nameHospital;
    private String diagnosis;
    private boolean anesthesia; //нужна или нет

    public Doctor(String nameHospital, String diagnosis, boolean anesthesia) {
        this.nameHospital = nameHospital;
        this.diagnosis = diagnosis;
        this.anesthesia = anesthesia;
    }
}
