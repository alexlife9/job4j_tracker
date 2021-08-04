package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

//проверка, если юзера нет, то добавляем его и добавляем к нему пустой список счетов
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

//ищем и проверяем юзера по паспорту
//если находим то получаем все счета юзера
//добавляем еще один счет, проверим что его еще не существует
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAcc = users.get(user);
            if (!userAcc.contains(account)) {
                userAcc.add(account);
            }
        }

    }

//ищем юзера по номеру паспорта
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            user.getPassport().equals(passport);
        }
        return null;
    }

//ищем изера, если находим, то получаем список его счетов и
//ищем нужный номер счета по реквизитам
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAcc = users.get(user);
            for (Account account : userAcc) {
                account.getRequisite().equals(requisite);
            }
        }
        return null;
    }
//ищем счета юзера по паспорту
//сравниваем где больше денег для перевода с одного счета на другой
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account scrAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (scrAcc != null || destAcc != null || scrAcc.getBalance() > amount) {
            scrAcc.setBalance() - amount;
            destAcc.setBalance() + amount;
        }
        return false;
    }
}
