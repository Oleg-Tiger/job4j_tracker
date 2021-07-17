package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Search item by id ===");
        int number = input.askInt("Enter id of item which you want to find");
        Item rsl = tracker.findById(number);
        if (rsl == null) {
            out.println("The item with entered id was not found");
        } else {
            out.println(rsl);
        }
        return true;
    }
}
