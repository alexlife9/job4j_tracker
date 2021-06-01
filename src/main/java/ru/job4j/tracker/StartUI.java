package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("New name Item: " + item);

            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                System.out.println(allItems);

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter ID item: ");
                String name = scanner.nextLine();
                int id = Integer.parseInt(scanner.nextLine());
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.print("Successfully!");
                } else {
                    System.out.println("Not found");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");

            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");

            } else if (select == 5) {
                System.out.println("=== Find items by name ====");

            } else if (select == 6) {
                run = false;

            } else if (select > 6) {
                System.out.println("Wrong choice!!!");
                System.out.println();
            }

        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}