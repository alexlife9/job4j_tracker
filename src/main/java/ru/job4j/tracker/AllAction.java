package ru.job4j.tracker;

import java.util.List;

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
        //Item[] allItems = tracker.findAll();
        List<Item> items = tracker.findAll();
            for (Item item : items) {
                out.println(item);
            }
        return true;
    }
}
