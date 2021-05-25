package ru.job4j.implementation;

public class Builder extends Engineer{
    public Builder(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private String buildingType;
    private String materials;
    private int numberFloors;


}
