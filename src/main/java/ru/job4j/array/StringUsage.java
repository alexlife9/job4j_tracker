package ru.job4j.array;

/**
 * String - это массив
 *
 * Текст в языка Java описывается ссылочным типом String. По сути String эта обертка над массивом символов.
 * Класс String имеет удобные методы для работы со строкой, как с массивом.
 * Существует большое кол-во задач на преобразование текста. Для решения этих задач нужно использовать методы String.
 * String имеет неизменяемый тип данных. То есть все методы String вернут новую строку.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class StringUsage {
    public static void main(String[] args) {
        /* Преобразование строки в массив. String.toCharArray() */
        String text1 = "Smith Will";
        char[] array1 = text1.toCharArray();
        System.out.println(array1);

        /* Преобразование массива в строку. String.valueOf() */
        char[] array2 = {'j', 'o', 'b', '4', 'j'};
        String text2 = String.valueOf(array2);
        System.out.println(text2);

        /* Извлечение символа из строки. String.charAt(). Индексы массивов начинаются с 0 */
        String text3 = "Smith Will";
        char surnameStart = text3.charAt(6);
        System.out.println(surnameStart);

        /* Поиск строки в подстроке. String.indexOf().
        Метод indexOf вернет индекс символа в исходной строке с которого начинается подстрока */
        String text4 = "Smith Will";
        String subtext4 = "Wi";
        int index4 = text4.indexOf(subtext4);
        System.out.println(index4);

        /* Еще один метод indexOf, который принимает два параметра.
        Второй параметр указывает на индекс начала поиска подстроки.*/
        String text5 = "Smith Will, He has a friend William.";
        String subtext5 = "Wi";
        int index5 = text5.indexOf(subtext5, 7);
        System.out.println(index5);

        /* Извлечение подстроки по индексам. String.substring(fromIndex, toIndex) */
        String text6 = "will_smith@gmail.com";
        int mailIndex = text6.indexOf("@") + 1;
        int end = text6.length();
        String domain = text6.substring(mailIndex, end);
        System.out.println(domain);

        /* Получение кода символа. String.codeAt(). Все символы имеют уникальный код в таблице Unicode */
        validatePhone("123456789");
        validatePhone("123-456-789");
    }

    public static void validatePhone(String phone) {
        boolean valid = true;
        for (int i = 0; i < phone.length(); i++) {
            int code = phone.codePointAt(i);
            if (code < 48 || code > 57) {
                valid = false;
                break;
            }
        }
        System.out.println(phone + " is " + ((valid) ? "correct" : "not correct"));
    }
}
