package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int number = input.askInt("Enter id of item which you want to delete");
        if (tracker.delete(number)) {
            System.out.println("Completed");
        } else {
            System.out.println("The item with entered id was not found");
        }
        return true;
    }
}
