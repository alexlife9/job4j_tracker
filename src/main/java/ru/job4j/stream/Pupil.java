package ru.job4j.stream;

import java.util.List;
/**
 * 1.Стажер
 * 1.4. FP, Lambda, Stream API
 * 2.Аттестация
 * В этом задании необходимо реализовать класс для подсчета статистики по аттестатам учеников.
 *
 * Класс Pupil описывает ученика.
 *
 * @author Alex_life
 * @since 14.09.2021
 * @version 1
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
