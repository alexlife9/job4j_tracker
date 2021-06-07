package ru.job4j.tracker;

public class AllAction implements UserAction {
    private final Output out;

    public AllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                out.println(item);
            }
        } else {
            out.println("Items not found!");
        }
        return true;
    }
}
