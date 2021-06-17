package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    public static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        String engines = name.equals("A380") ? ("Количество двигателей равно: " + 4)
                : ("Количество двигателей равно: " + COUNT_ENGINE);
        System.out.println(engines);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}