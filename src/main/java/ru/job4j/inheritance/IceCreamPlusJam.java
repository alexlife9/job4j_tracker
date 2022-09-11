package ru.job4j.inheritance;

/**
 * Вызов переопределенного метода родителя - super.method
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class IceCreamPlusJam extends IceCream {
    private static final int JAM_PRICE = 50;

    public IceCreamPlusJam(int weight) {
        super(weight);
    }

    /*Каждый наследник должен добавить к сумме родителя свою стоимость и для этого мы используем вызов super.price() */
    @Override
    public int price() {
        return JAM_PRICE + super.price();
    }
}
