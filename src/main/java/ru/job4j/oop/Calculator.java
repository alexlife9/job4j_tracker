package ru.job4j.oop;

/**
 * Статические и не статические методы
 *
 * Статические методы обычно используются для выполнения операции, не зависящей от создания экземпляра.
 * При этом, они широко используются для создания служебных (утилитных) или вспомогательных классов,
 * поскольку их можно вызывать без создания объекта этих классов.
 *
 * В JDK служебные классы используются: Collections, Math, Arrays. Все методы этих классов являются статическими.
 *
 * Когда стоит использовать статические методы^
 * 1. Для доступа или управления статическими переменными и другими статическими методами, которые не зависят от объектов;
 * 2. Для служебных, вспомогательных классов и интерфейсов, поскольку не требуют создания объекта и соответственно,
 * обеспечивают большую производительность;
 * 3. Когда методу требуется доступ лишь к статическим полям класса.
 *
 * Особенности статических методов:
 * 1. Статические методы нельзя переопределять. Статические методы не имеют возможности быть переопределенными;
 * 2. Статические методы не могут использовать
 * ключевые слова this (ссылка на текущий объект) или super (ссылка на объект суперкласса);
 * 3. Нестатические методы могут обращаться непосредственно как к методам класса, так и к переменным класса;
 * 4. Нестатические методы могут обращаться к статическим переменным и статическим методам;
 * 5. Статические методы могут обращаться ко всем статическим переменным и другим статическим методам.
 * Однако они не могут обращаться к переменным класса и нестатическим методам. Для этого им нужны ссылки на объект.
 *
 * @author Alex_life
 * @version 1.0
 * @since 23.07.2022
 */
public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int p) {
        return sum(p) + multiply(p) + minus(p) + divide(p);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        int rsl2 = Calculator.minus(15);
        System.out.println(rsl2);

        Calculator calculator2 = new Calculator();
        int rsl3 = calculator2.divide(30);
        System.out.println(rsl3);

        Calculator calculator3 = new Calculator();
        int rsl4 = calculator3.sumAllOperation(100);
        System.out.println(rsl4);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
    }
}

