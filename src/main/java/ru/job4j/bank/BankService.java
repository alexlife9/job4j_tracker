package ru.job4j.bank;

import ru.job4j.map.Subject;

import java.util.*;

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
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * присваиваем клиенту его паспорт и создаем дл него персональный аккаунт в банке
     * проверяем по имени что клиента еще нет в списке клиентов банка
     * @param passport
     * @param account - описание параметра
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAcc = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                    .stream()
                    .filter(s -> s.getPassport().equals(passport))
                    .findFirst();
        }

    /**
     * ищем номер счета клиента по его паспорту
     * @param passport
     * @param requisite
     * @return возвращаем номер счета или null если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> scrAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (scrAcc.isPresent()
                && destAcc.isPresent()
                && amount > 0
                && scrAcc.get().getBalance() >= amount) {
            scrAcc.get().setBalance(scrAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
