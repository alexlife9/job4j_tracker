package ru.job4j.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.array.NameValid.*;

/**
 * Проверка валидности имен в языке Java
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.09.2022
 */
class NameValidTest {

    @Test
    void whenEmptyNameInvalid() {
        assertThat(isNameValid("")).isFalse();
    }

    @Test
    void whenFullLatValid() {
        assertThat(isNameValid("first")).isTrue();
    }

    @Test
    void whenFullLatAndSomeUpperCaseLettersValid() {
        assertThat(isNameValid("fIRST")).isTrue();
    }

    @Test
    void whenLatNumberValid() {
        assertThat(isNameValid("first1")).isTrue();
    }

    @Test
    void whenLatWithSpecialSymbolUnderValid() {
        assertThat(isNameValid("first_user")).isTrue();
    }

    @Test
    void whenNumberInValid() {
        assertThat(isNameValid("123")).isFalse();
    }

    @Test
    void whenFirstLatinUpperCaseIsInvalid() {
        assertThat(isNameValid("First")).isFalse();
    }

    @Test
    void whenLatNumberAndTwoSpecialSymbolsUnderValid() {
        assertThat(isNameValid("fir$t_u$er_1")).isTrue();
    }

    /* альтернатива */
    @Test
    void whenEmptyNameInvalidAlt() {
        assertThat(isNameValidAlternative("")).isFalse();
    }

    @Test
    void whenFullLatValidAlt() {
        assertThat(isNameValidAlternative("first")).isTrue();
    }

    @Test
    void whenFullLatAndSomeUpperCaseLettersValidAlt() {
        assertThat(isNameValidAlternative("fIRST")).isTrue();
    }

    @Test
    void whenLatNumberValidAlt() {
        assertThat(isNameValidAlternative("first1")).isTrue();
    }

    @Test
    void whenLatWithSpecialSymbolUnderValidAlt() {
        assertThat(isNameValidAlternative("first_user")).isTrue();
    }

    @Test
    void whenNumberInValidAlt() {
        assertThat(isNameValidAlternative("123")).isFalse();
    }

    @Test
    void whenFirstLatinUpperCaseIsInvalidAlt() {
        assertThat(isNameValidAlternative("First")).isFalse();
    }

    @Test
    void whenLatNumberAndTwoSpecialSymbolsUnderValidAlt() {
        assertThat(isNameValidAlternative("fir$t_u$er_1")).isTrue();
    }
}