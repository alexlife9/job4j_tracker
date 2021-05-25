package ru.job4j.implementation;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private boolean appendicitis; //диагноз аппендицит
    private String fracture; //перелом
    private int numberOfStitches; //кол-во швов
}
