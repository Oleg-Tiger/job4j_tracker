package ru.job4j.lambda;

import java.util.Comparator;

/**
 * В этом классе учимся описывать лямбда через блок.
 * Наша задача - в  методе main() создать 2 компоратора строк
 * с помощью лямбда, добавить вывод в консоль отладочной информации.
 */
public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
    }
}
