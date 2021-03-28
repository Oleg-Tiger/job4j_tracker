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
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
       Account result = null;
       User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
               if (account.getRequisite().equals(requisite)) {
                   result = account;
               }
            }
        }
       return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dst = findByRequisite(destPassport, destRequisite);
        if (src == null || dst == null || src.getBalance() < amount) {
            rsl = false;
        } else {
            src.setBalance(src.getBalance() - amount);
            dst.setBalance(dst.getBalance() + amount);
        }
        return rsl;
    }
}