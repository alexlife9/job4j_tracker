package ru.job4j.implementation;

public class Programmer extends Engineer {

    private String programmingLanguage;

    public Programmer(String name, String surname, String education,
                      double birthday, String drawing, double scaleDrawing,
                      String programmingLanguage) {
        super(name, surname, education, birthday, drawing, scaleDrawing);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}