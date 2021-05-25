package ru.job4j.implementation;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private String caries; //тип кариеса
    private int badTooth; //номер больного зуба
    private boolean malocclusion; //наличие неправильного прикуса
}
