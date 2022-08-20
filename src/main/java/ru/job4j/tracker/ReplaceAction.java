package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ====");
        int id = input.askInt("Enter ID item: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Successfully! New Item name: " + item);
        } else {
            out.println("Id not found!");
        }
        return true;
    }
}
