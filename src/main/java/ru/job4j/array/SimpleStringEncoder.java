package ru.job4j.array;

/**
 * Реализовать элементарный алгоритм сжатия строки на основе счетчика повторяющихся символов
 *
 * @author Alex_life
 * @version 1.1
 * @since 22.09.2023
 */
public class SimpleStringEncoder {
    public static String encode(String input) {
        StringBuilder compress = new StringBuilder();
        char symbol = input.charAt(0);
        int counter = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == symbol) {
                counter++;
            } else {
                compress.append(symbol);
                if (counter > 1) {
                    compress.append(counter);
                }
                symbol = input.charAt(i);
                counter = 1;
            }
        }

        compress.append(symbol);
        if (counter > 1) {
            compress.append(counter);
        }

        return compress.toString();
    }
}