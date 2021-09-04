package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);

        List<Task> bugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<String> names = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        System.out.println("Имена задач: " + names);

        long total = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println("Время на задачи: " + total);

        List<Integer> numbers = Arrays.asList(1, -1, 2, -2, 3, -3);
        List<Integer> positiveNumbers = numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}
