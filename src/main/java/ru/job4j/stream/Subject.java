package ru.job4j.stream;
/**
 * 1.Стажер
 * 1.4. FP, Lambda, Stream API
 * 2.Аттестация
 * В этом задании необходимо реализовать класс для подсчета статистики по аттестатам учеников.
 *
 * Класс Subject описывает школьный предмет и аттестационный балл ученика.
 *
 * @author Alex_life
 * @since 14.09.2021
 * @version 1
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
