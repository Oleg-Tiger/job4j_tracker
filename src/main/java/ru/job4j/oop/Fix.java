package ru.job4j.oop;

public class Fix {

    private String desc;

    public Fix(String text) {
    this.desc = text;
    }

    public static void main(String[] args) {
Fix fix = new Fix("Инициализация поля desc для объекта fix c помощью конструктора");
    }
}
