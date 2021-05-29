package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime currentDateTime = item.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);

        Tracker tracker = new Tracker();
        Item items = new Item();
        tracker.add(items);
        System.out.println(tracker.findById(items.getId()));

        System.out.println("Item: "
                + item.getId() + " "
                + item.getName() + " "
                + item.getCreated()
        );
    }
}
