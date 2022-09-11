package ru.job4j.inheritance;

/**
 * Вызов переопределенного метода родителя - super.method
 *
 * В этом задании нужно доработать иерархию пиццы: Pizza -> PizzaExtraCheese -> PizzaExtraCheeseExtraTomato.
 * Нужно создать наследников PizzaExtraCheese -> PizzaExtraCheeseExtraTomato. В наследниках переопределить метод name()
 * Метод name() должен получить имя пиццы родителя и добавить свой топпинг: сыр и томаты.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class Pizza {
    public String name() {
        return "Just tasty pizza";
    }
}
