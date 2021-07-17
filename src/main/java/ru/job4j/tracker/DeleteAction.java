package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int number = input.askInt("Enter id of item which you want to delete");
        if (tracker.delete(number)) {
            out.println("Completed");
        } else {
            out.println("The item with entered id was not found");
        }
        return true;
    }
}
