package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
