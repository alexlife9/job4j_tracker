package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

/**
 * Валидатор пароля
 *
 * @author Alex_life
 * @version 3.0
 * @since 07.09.2022
 */
public class PasswordValidatorTest {

    @Test
    void whenCorrect() {
        String wrongPassword = "password";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage())
                .isEqualTo("Пароль не должен быть таким: qwerty, 12345, password, admin, user");
    }

    @Test
    void whenLength() {
        String wrongPassword = "Pass567";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage()).isEqualTo("Длина пароля должна находиться в диапазоне [8, 32]");
    }

    @Test
    void whenUpSymbol() {
        String wrongPassword = "pass56789";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в верхнем регистре");
    }

    @Test
    void whenLowSymbol() {
        String wrongPassword = "PAS56789";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в нижнем регистре");
    }

    @Test
    void whenDigit() {
        String wrongPassword = "PasPasPa%";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    void whenSpecialSymbol() {
        String wrongPassword = "Pass56789";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(wrongPassword));
        assertThat(exception.getMessage())
                .isEqualTo("Пароль должен содержать хотя бы один спецсимвол (не цифра и не буква)");
    }

    @Test
    void whenCorrectPass() {
        String password = "Pass5678%";
        assertThat(PasswordValidator.validate(password)).isEqualTo("Пароль подходит");
    }

}