package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс описывает модель счёта пользователя.
 * @author OLEG ERSHOV
 * @version 1.0
 */
public class Account {

    /**
     * Хранение реквизитов счёта осущестивляется в переменной requisite типа String.
     * Остаток по балансу на данном счёте хранится в переменной balance типа int.
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределённый метод equals().
     * Возвращает true, если ссылки на объекты равны, либо, если
     * равны значения полей requisite двух объектов.
     */
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

    /**
     * Переопределённый метод hashCode().
     * Возвращает true, если равны хэш-коды полей requisite для двух объектов.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}