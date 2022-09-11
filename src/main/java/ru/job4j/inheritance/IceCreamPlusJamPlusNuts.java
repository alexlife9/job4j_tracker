package ru.job4j.inheritance;

/**
 * Вызов переопределенного метода родителя - super.method
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class IceCreamPlusJamPlusNuts extends IceCreamPlusJam {
    private static final int NUTS_PRICE = 25;

    public IceCreamPlusJamPlusNuts(int weight) {
        super(weight);
    }

    /*Каждый наследник должен добавить к сумме родителя свою стоимость и для этого мы используем вызов super.price() */
    @Override
    public int price() {
        return NUTS_PRICE + super.price();
    }

    public static void main(String[] args) {
        IceCreamPlusJamPlusNuts iceCream = new IceCreamPlusJamPlusNuts(4);
        System.out.println(iceCream.price());
    }
}
