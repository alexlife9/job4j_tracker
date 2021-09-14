package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;

/**
 * 1.Стажер
 * 1.4. FP, Lambda, Stream API
 * 2.Аттестация
 * В этом задании необходимо реализовать класс для подсчета статистики по аттестатам учеников.
 * Все методы нужно реализовывать в одном потоке,
 * т.е. пишем return и последовательно вызываем все методы, о которых было указано.
 *
 * Класс Analyze получает статистику по аттестатам.
 *
 * @author Alex_life
 * @since 14.09.2021
 * @version 1
 */
public class Analyze {

    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * flatMap() для преобразования в поток объектов Subject;
     * mapToInt() для последующего преобразования в поток оценок по каждому предмету;
     * average() для расчета среднего балла по предмету;
     * orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .mapToInt(Subject :: getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     *
     * метод map() для преобразования в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple().
     *
     * при этом в конструктор первым параметром
     * будет передаваться имя текущего объекта Pupil - используем соответствующий геттер;
     *
     * вторым параметром рассчитанный средний балл - расчет можно произвести
     * по той же последовательности, что описана для метода averageScore;
     *
     * последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pup -> new Tuple(
                        pup.getName(),
                        pup.getSubjects()
                                .stream()
                                .mapToInt(Subject :: getScore)
                                .average()
                                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     *
     * Реализация этого метода несколько сложна, поскольку в данном случае требуется
     * выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     *
     * - flatMap() для преобразования в поток объектов Subject;
     *
     * - метод collect() в который мы передаем
     *                   метод groupingBy() (минимум с двумя параметрами) класса Collectors.
     * При этом карта собирается следующим образом:
     *                               ключ - это имя предмета,
     *                               значение - средний балл по этому предмету для каждого ученика.
     * Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
     *
     * - после этого собранную карту мы разбираем с помощью entrySet()
     *                                            и открываем поток с помощью stream();
     *
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     *
     * - в конструктор мы будем передавать параметры
     *                               с помощью методов getKey() и getValue() интерфейса Entry;
     *
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tup -> new Tuple(tup.getKey(), tup.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * Для реализации данного метода можно использовать
     * метод averageScoreBySubject за исключением следующих особенностей:
     *
     * - в данном методе мы рассчитываем суммарный балл,
     * а не средний - поэтому вместо average() нужно использовать метод sum();
     *
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     *
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pup -> new Tuple(
                        pup.getName(),
                        pup.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     *
     * Для реализации данного метода можно использовать
     * метод averageScoreByPupil за исключением следующих особенностей:
     *
     * - в данном методе мы рассчитываем суммарный балл,
     * а не средний - поэтому вместо averagingDouble() нужно использовать метод summingDouble();
     *
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     *
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tup -> new Tuple(tup.getKey(), tup.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
