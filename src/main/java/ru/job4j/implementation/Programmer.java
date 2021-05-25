package ru.job4j.implementation;

public class Programmer extends Engineer {

    private String programmingLanguage;
    private String lastProect;

    public Programmer(String name, String surname, String education, double birthday, String drawing, double scaleDrawing, String programmingLanguage, String lastProect) {
        super(name, surname, education, birthday, drawing, scaleDrawing);
        this.programmingLanguage = programmingLanguage;
        this.lastProect = lastProect;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getLastProect() {
        return lastProect;
    }
}
