package ru.job4j.implementation;

public class Builder extends Engineer{

    private String buildingType;
    private int numberFloors;


    public Builder(String name, String surname, String education, double birthday, String drawing, double scaleDrawing, String buildingType, int numberFloors) {
        super(name, surname, education, birthday, drawing, scaleDrawing);
        this.buildingType = buildingType;
        this.numberFloors = numberFloors;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getNumberFloors() {
        return numberFloors;
    }
}
