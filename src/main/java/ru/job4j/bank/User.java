package ru.job4j.bank;

import java.util.Objects;

/**
 * класс User описывает клиента по паспорту и имени
 * @author Alex_life
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращаем данные паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport изменяем или устанавливаем новые данные паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return возвращаем ФИО клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username изменяем или устанавливаем новые ФИО клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
