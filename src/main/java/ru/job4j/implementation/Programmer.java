package ru.job4j.implementation;

public class Programmer extends Engineer {
    public Programmer(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    private String programmingLanguage;
    private String lastProect;
    private boolean knowledgeSpring;

}
