package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("===  Show all items ===");
        Item[] rsl = tracker.findAll();
        if (rsl.length > 0) {
            for (Item items : rsl) {
                System.out.println(items);
            }
        } else {
            System.out.println("Items not found");
        }
        return true;
    }
}
