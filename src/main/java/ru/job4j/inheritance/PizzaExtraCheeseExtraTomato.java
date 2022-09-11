package ru.job4j.inheritance;

/**
 * Вызов переопределенного метода родителя - super.method
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    @Override
    public String name() {
        return super.name() + " + extra tomato";
    }
}
