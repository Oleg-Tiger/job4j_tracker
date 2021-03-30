package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы.
 * @author OLEG ERSHOV
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение пользователя и его банковских счетов осуществляется
     * в коллекции типа HashMap. Объект пользователь используется
     * в качестве ключа, а счета в качестве значения в виде коллекции ArrayList.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию.
     * В качестве значения в коллекции создаётся незаполненный список.
     * Если ползователь с такими же паспортными данными уже есть в коллекции,
     * то новый пользователь не добавляется.
     * @param user пользователь, который добавляется в коллекцию.
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и банковский счёт,
     * который нужно создать для данного пользователя.
     * Если пользователь с такими паспортными данными найден и у него нет счёта с такими же
     * реквизитами, для него создаётся такой счёт. В противном случае метод ничего не делает.
     * @param passport паспортные данные пользователя.
     * @param account банковский счёт пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные и находит пользователя по ним.
     * @param passport паспортные данные пользователя.
     * @return возвращает пользователя или null,если пользователь
     * с такими паспортными данными не найден.
     */
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

    /**
     * Метод принимает на вход паспортные данные и реквизиты счёта и
     * возвращает счёт с данными реквизитами у данного пользователя.
     * @param passport паспортные данные пользователя.
     * @param requisite реквизиты счёта.
     * @return возвращает счёт с переданными реквизитами, если такой имеется
     * у пользователя с переданными паспортными данными. Иначе, возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
       Account result = null;
       User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
               if (account.getRequisite().equals(requisite)) {
                   result = account;
                   break;
               }
            }
        }
       return result;
    }

    /**
     * Метод принимает на вход паспортные данные двух пользователей и двое реквизитов счетов, а
     * также сумму перевода, и выполняет перевод с одного счёта на другой.
     * @param srcPassport паспортные данные пользователя, со счёта которого осуществляется перевод.
     * @param srcRequisite реквизиты счёта, с которого осуществляется перевод.
     * @param destPassport паспортные данные пользователя, на счёт которого осуществляется перевод.
     * @param destRequisite реквизиты счёта, на который осуществляется перевод.
     * @param amount сумма перевода.
     * @return возвращает true, если перевод выполнен и false, если один из счетов или пользователей
     * не найден, либо сумма перевода привышает остаток на счёте, с которого выполняется перевод.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dst = findByRequisite(destPassport, destRequisite);
        if (src != null && dst != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dst.setBalance(dst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}