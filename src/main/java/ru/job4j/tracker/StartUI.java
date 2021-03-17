package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] rsl = tracker.findAll();
                if (rsl.length > 0) {
                    for (Item items : rsl) {
                        System.out.println(items);
                    }
                } else {
                    System.out.println("Items not found");
                    }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter id of item which you want to edit");
                int number = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(number, newItem)) {
                    System.out.println("Completed");
                } else {
                    System.out.println("The item with entered id was not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter id of item which you want to delete");
                int number = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(number)) {
                    System.out.println("Completed");
                } else {
                    System.out.println("The item with entered id was not found");
                }
            } else if (select == 4) {
                System.out.println("=== Search item by id ===");
                System.out.println("Enter id of item which you want to find");
                int number = Integer.valueOf(scanner.nextLine());
                Item rsl = tracker.findById(number);
                if (rsl == null) {
                    System.out.println("The item with entered id was not found");
                } else {
                    System.out.println(rsl);
                }
            } else if (select == 5) {
                System.out.println("=== Search items by name ===");
                System.out.println("Enter name of items which you want to find");
                String name = scanner.nextLine();
                Item[] rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (Item items : rsl) {
                        System.out.println(items);
                    }
                } else {
                    System.out.println("Items with entered name was not found");
                    }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Вы ввели некорректное значение");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}