package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() < task.getPriority()) {
                index++;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}

//Нужно пройти циклом по tasks, сравнивая в if приоритет element с приоритетом task.
//Если приоритет больше у task, index увеличить на 1.
//Если приоритет больше у element, прервать цикл и по текущему индексу записать task в tasks.