package ru.job4j.implementation;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, double birthday, String nameHospital, String diagnosis) {
        super(name, surname, education, birthday);
        this.nameHospital = nameHospital;
        this.diagnosis = diagnosis;
    }

    private String nameHospital;
    private String diagnosis;

    public String getNameHospital() {
        return nameHospital;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
