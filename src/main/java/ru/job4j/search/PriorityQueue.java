package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 * @author Alex_life
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение задания осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Позиция определяется по полю приоритет.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO (первым пришел - первым ушел).
     * Для вставки использовать add(int index, E value)
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        var index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из начала очереди или null если очередь пуста
     */
    public Task take() {
        return tasks.poll();
    }
}

//Нужно пройти циклом по tasks, сравнивая в if приоритет element с приоритетом task.
//Если приоритет больше у task, index увеличить на 1.
//Если приоритет больше у element, прервать цикл и по текущему индексу записать task в tasks.