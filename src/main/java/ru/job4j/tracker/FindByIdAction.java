package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search item by id ===");
        int number = input.askInt("Enter id of item which you want to find");
        Item rsl = tracker.findById(number);
        if (rsl == null) {
            System.out.println("The item with entered id was not found");
        } else {
            System.out.println(rsl);
        }
        return true;
    }
}
