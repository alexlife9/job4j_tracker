package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

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
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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
