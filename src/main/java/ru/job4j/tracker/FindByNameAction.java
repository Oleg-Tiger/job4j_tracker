package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Search items by name ===");
        String name = input.askStr("Enter name of items which you want to find");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (Item items : rsl) {
                out.println(items);
            }
        } else {
            out.println("Items with entered name was not found");
        }
        return true;
    }
}
