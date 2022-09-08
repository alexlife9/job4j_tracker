package ru.job4j.early;

/**
 * Валидатор пароля
 *
 * Принципы раннего возврата и охранных выражений
 *
 * Суть принципа раннего возврата - если результат известен, то его нужно возвращать сразу.
 * Причем возврат != return. Под возвратом подразумевается выход из метода, поэтому это может как return, так и throw.
 * Принцип охранных выражений идет рука об руку с принципом раннего возврата,
 * т.к. предполагает предварительную проверку параметров и переменных до их фактического использования и
 * остановку выполнения (например, через выброс исключения) метода. В отличие от первого принципа,
 * этот принцип предполагает необходимость самой проверки.
 * По сути, ошибка должна быть найдена на этапе валидации (проверки параметров и переменных), а не на этапе исполнения.
 * Подобная практика позволяет быстро определять, была ли ошибка во входных данных, или же в самом алгоритме.
 *
 * Условно, принцип раннего возврата = if + return, а принцип охранных выражений = if + throws.
 *
 * Нарушение этих принципов обычно сопровождается такими признаками, как:
 * 1) Повышенная вложенность кода, которая достигается конструкциями if-else
 * 2) Локальные переменные, которые контролируют выполнение программы
 * 3) Отсутствуют проверки параметров (если они действительно необходимы)


 * Задание.
 * 1. Добавить валидацию в метод validate(), применив принцип охранных выражений.
 * Если password null, то выбросить исключение IllegalArgumentException;
 *
 * 2. Учесть требования к паролю ниже.
 * Если хотя бы одно из требований нарушается, то возвращать нужно соответствующее сообщение:
 * 1) Длина пароля находится в диапазоне [8, 32];
 * 2) Пароль содержит хотя бы один символ в верхнем регистре;
 * 3) Пароль содержит хотя бы один символ в нижнем регистре;
 * 4) Пароль содержит хотя бы одну цифру;
 * 5) Пароль содержит хотя бы один спец. символ (не цифра и не буква);
 * 6) Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user.
 * Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п. быть не должно быть в составе пароля.
 *
 * Для проверок использовать статические методы класса Character.
 *
 * 3. Создать класс PasswordValidatorTests.
 * Реализовать Unit тесты, которые учитывают все условия, реализованные в методе validate();

 * @author Alex_life
 * @version 3.0
 * улучшение кода
 * @since 08.09.2022
*/
public class PasswordValidator {

    private static String pass;

    private static char[] chars;

    public static String validate(String password) {
        if (password == null) {
            message("Необходимо заполнить пароль");
        }

        pass = password;
        chars = pass.toCharArray();

        String[] word = {"qwerty", "12345", "password", "admin", "user"};
        for (String pas : word) {
            if (password.toLowerCase().contains(pas)) {
                message("Пароль не должен быть таким: qwerty, 12345, password, admin, user");
            }
        }

        checkLength();
        checkUpSymbol();
        checkLowSymbol();
        checkSpecialSymbol();
        checkDigit();

        return "Пароль подходит";
    }

    private static void checkLength() {
        if (pass.length() < 8 || pass.length() > 32) {
            message("Длина пароля должна находиться в диапазоне [8, 32]");
        }
    }

    private static void checkUpSymbol() {
        boolean check = false;
        for (char symbol : chars) {
            if (Character.isUpperCase(symbol)) {
                check = true;
                break;
            }
        }
        if (!check) {
            message("Пароль должен содержать хотя бы один символ в верхнем регистре");
        }
    }

    private static void checkLowSymbol() {
        boolean check = false;
        for (char symbol : chars) {
            if (Character.isLowerCase(symbol)) {
                check = true;
                break;
            }
        }
        if (!check) {
            message("Пароль должен содержать хотя бы один символ в нижнем регистре");
        }
    }

    private static void checkDigit() {
        boolean check = false;
        for (char symbol : chars) {
            if (Character.isDigit(symbol)) {
                check = true;
                break;
            }
        }
        if (!check) {
            message("Пароль должен содержать хотя бы одну цифру");
        }
    }

    private static void checkSpecialSymbol() {
        boolean check = false;
        for (char symbol : chars) {
            if (!Character.isLetterOrDigit(symbol)) {
                check = true;
                break;
            }
        }
        if (!check) {
            message("Пароль должен содержать хотя бы один спецсимвол (не цифра и не буква)");
        }
    }

    private static void message(String msg) {
        throw new IllegalArgumentException(msg);

    }
}

