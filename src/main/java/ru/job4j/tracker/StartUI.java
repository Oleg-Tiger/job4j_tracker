package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Tracker tracker) {
        System.out.println("===  Show all items ===");
        Item[] rsl = tracker.findAll();
        if (rsl.length > 0) {
            for (Item items : rsl) {
                System.out.println(items);
            }
        } else {
            System.out.println("Items not found");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int number = input.askInt("Enter id of item which you want to edit");
        String name = input.askStr("Enter new name");
        Item newItem = new Item(name);
        if (tracker.replace(number, newItem)) {
            System.out.println("Completed");
        } else {
            System.out.println("The item with entered id was not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int number = input.askInt("Enter id of item which you want to delete");
        if (tracker.delete(number)) {
            System.out.println("Completed");
        } else {
            System.out.println("The item with entered id was not found");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Search item by id ===");
        int number = input.askInt("Enter id of item which you want to find");
        Item rsl = tracker.findById(number);
        if (rsl == null) {
            System.out.println("The item with entered id was not found");
        } else {
            System.out.println(rsl);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Search items by name ===");
        String name = input.askStr("Enter name of items which you want to find");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (Item items : rsl) {
                System.out.println(items);
            }
        } else {
            System.out.println("Items with entered name was not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showItems(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Invalid value");
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
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}