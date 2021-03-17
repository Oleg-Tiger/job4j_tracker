package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок," : "Второй игрок,";
            System.out.println(player + " введите число от 1 до 3, осталось " + count + " спичек:");
            try {
                int matches = Integer.parseInt(input.nextLine());
                while (matches < 1 || matches > 3 || matches > count) {
                    System.out.print("Вы должны ввести число не менее 1 и не более 3.");
                    System.out.println(" Также обратите внимание на количество оставшихся спичек: " + count);
                    System.out.println(player + " повторите ввод:");
                    matches = Integer.parseInt(input.nextLine());
                }
                turn = !turn;
                count -= matches;
            } catch (NumberFormatException e) {
                System.out.println("Не надо вводить другие символы");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}