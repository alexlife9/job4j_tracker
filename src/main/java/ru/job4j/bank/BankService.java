package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс описывает пример работы простого банковского сервиса
 * на основании паспортных данных клиента и его банковских счетов
 * @author Alex_life
 * @version 1.0
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавляем имя клиента в изначально пустой список пользователй
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * присваиваем клиенту его паспорт и создаем дл него персональный аккаунт в банке
     * проверяем по имени что клиента еще нет в списке клиентов банка
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAcc = users.get(user);
            if (!userAcc.contains(account)) {
                userAcc.add(account);
            }
        }
    }

    /**
     * в списке банка ищем клиента по номеру паспорта
     * @param passport
     * @return возвращает клиента или null если клиент не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * ищем номер счета клиента по его паспорту
     * @param passport
     * @param requisite
     * @return возвращаем номер счета или null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAcc = users.get(user);
            for (Account account : userAcc) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * осуществляем перевод с одного счета на другой
     * @param srcPassport паспорт клиента у которого будет проводится перевод
     * @param srcRequisite номер счета с которого будет производится перевод
     * @param destPassport паспорт клиента на который будет зачисляться перевод
     * @param destRequisite номер счета на который будет зачислен перевод
     * @param amount сумма перевода
     * @return возвращаем true если перевод удачен или false если не удалось
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account scrAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (scrAcc != null && destAcc != null && amount > 0 && scrAcc.getBalance() >= amount) {
            scrAcc.setBalance(scrAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return false;
    }
}
