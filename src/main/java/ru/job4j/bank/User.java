package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс описывает модель объекта пользователя.
 * @author OLEG ERSHOV
 * @version 1.0
 */
public class User {

    /**
     * Паспортные данные пользователя хранятся в переменной passport Типа String.
     * Имя пользователя хранится в переменной username Типа String.
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределённый метод equals().
     * Возвращает true, если ссылки на объекты равны, либо, если
     * равны значения полей passport двух объектов.
     */
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

    /**
     * Переопределённый метод hashCode().
     * Возвращает true, если равны хэш-коды полей passport для двух объектов.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}