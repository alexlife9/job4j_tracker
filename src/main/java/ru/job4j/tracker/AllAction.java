package ru.job4j.tracker;

public class AllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items not found!");
        }
        return true;
    }
}
