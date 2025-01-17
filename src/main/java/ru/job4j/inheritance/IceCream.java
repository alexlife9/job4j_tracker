package ru.job4j.inheritance;

/**
 * Вызов переопределенного метода родителя - super.method
 *
 * Лучше никогда не вызывать super.method. В целом механизм наследования старайтесь никогда не использовать.
 * Бездоказательный аргумент, что в языке GoLang механизма наследования не сделали.
 * Все что касается наследования могут спросить на собеседовании, но в практике этого использовать не надо.
 * Да и если спрашивают про наследование, я бы задумался, стоит ли идти в компанию,
 * где продолжают использовать этот механизм для расширения кода.
 *
 * Рассмотрим пример с расчетом мороженного. Есть киоск по продаже мороженного.
 * Когда вы покупаете шарик мороженного в него можно добавить топпинги. За каждый топпинг нужно доплатить.
 * Такой случай можно представить иерархией: IceCream -> IceCream + Jam -> IceCream + Jam + Nuts.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class IceCream {
    private int weight;

    public IceCream(int weight) {
        this.weight = weight;
    }

    public int price() {
        return weight * 100;
    }
}
