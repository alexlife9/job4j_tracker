package ru.job4j.stream;

import java.util.Objects;
/**
 * 1.Стажер
 * 1.4. FP, Lambda, Stream API
 * 2.Аттестация
 * В этом задании необходимо реализовать класс для подсчета статистики по аттестатам учеников.
 *
 * Класс Tuple содержит результаты: имя и баллы.
 * Этот класс используется как для учеников, так и для предметов.
 *
 * @author Alex_life
 * @since 14.09.2021
 * @version 1
 */
public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
