package ru.job4j.array;

/**
 * Проверка валидности имен в языке Java
 *
 * Имя переменной может содержать символы латинского алфавита и числа, символ подчеркивания и символ доллара.
 * Переменная должна начинаться на строчную латинскую букву.
 *
 * Для того, чтобы проверить является ли символ числом, используем метод isDigit() класса Character.
 * Данный метод возвращает true в том случае, если код символа является цифрой.
 *
 * Чтобы проверить что первый символ в строке строчный символ, используем метод isUpperCase(int).
 * Если метод вернет true - то наша строка невалидна и разработанный метод должен вернуть false.
 *
 * Чтобы проверить что исходная строка может быть пустой, используем метод isEmpty() класса String.
 * Метод вернет true в том случае, если длина строки равна 0, иначе false.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
public class NameValid {

    /* метод проверяет валидность имени переменной */
    public static boolean isNameValid(String name) {
        boolean result = !name.isEmpty()
                        && Character.isLetter(name.codePointAt(0))
                        && !Character.isUpperCase(name.codePointAt(0));
        if (result) {
            for (int i = 1; i < name.length(); i++) {
                int code = name.codePointAt(i);
                if (!(isSpecialSymbol(code)
                        || isUpperLatinLetter(code)
                        || isLowerLatinLetter(code)
                        || Character.isDigit(code))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /* метод должен вернуть true, если символ является символом доллара и нижнее подчеркивание */
    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }

    /* метод должен вернуть true, если символ является прописным латинским символом */
    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    /* метод должен вернуть true, если символ является строчным латинским символом */
    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }

    /* метод регулярных выражений */
    public static boolean isNameValidAlternative(String name) {
        return name.matches("^[a-z][a-zA-Z0-9_$]{0,}");
    }

}
