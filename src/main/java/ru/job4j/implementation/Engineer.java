package ru.job4j.implementation;

public class Engineer extends Profession {
    public Engineer(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private String drawing;
    private double scaleDrawing; //масштаб чертежа
    private boolean calculator; //использование калькулятора

}
