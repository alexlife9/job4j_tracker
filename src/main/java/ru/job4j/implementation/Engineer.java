package ru.job4j.implementation;

public class Engineer extends Profession {
    public Engineer(String name, String surname, String education, double birthday, String drawing, double scaleDrawing) {
        super(name, surname, education, birthday);
        this.drawing = drawing;
        this.scaleDrawing = scaleDrawing;
    }

    private String drawing;
    private double scaleDrawing; //масштаб чертежа

    public String getDrawing() {
        return drawing;
    }

    public double getScaleDrawing() {
        return scaleDrawing;
    }
}
