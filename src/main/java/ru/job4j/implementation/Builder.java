package ru.job4j.implementation;

public class Builder extends Engineer {

    private String buildingType;

    public Builder(String name, String surname, String education, double birthday,
                   String drawing, double scaleDrawing, String buildingType) {
        super(name, surname, education, birthday, drawing, scaleDrawing);
        this.buildingType = buildingType;
    }

    public String getBuildingType() {
        return buildingType;
    }
}