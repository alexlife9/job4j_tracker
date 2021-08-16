package ru.job4j.bank;

import java.util.Objects;

/**
 * Урок 3.Банковские переводы
 * Класс описывает работу банковского аккаунта клиента
 * в зависимости от баланса и реквизитов счета
 * @author Alex_life
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return возвращает имеющиеся реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * @param requisite изменяет и устанавливает новые реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * @return возвращает имеющийся баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance изменяет и устанавливает новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
