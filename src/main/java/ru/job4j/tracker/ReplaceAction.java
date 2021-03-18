package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int number = input.askInt("Enter id of item which you want to edit");
        String name = input.askStr("Enter new name");
        Item newItem = new Item(name);
        if (tracker.replace(number, newItem)) {
            System.out.println("Completed");
        } else {
            System.out.println("The item with entered id was not found");
        }
        return true;
    }
}
