package ru.job4j.tracker;

public class StartUI {

/*    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void allItem(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items not found!");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter ID item: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.print("Successfully! New Item name: " + item);
        } else {
            System.out.println("Id not found!");
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
            System.out.println("=== Delete item ====");
            int id = input.askInt("Enter ID item: ");
            if (tracker.delete(id)) {
                System.out.println("Successfully! Item with ID" + id + " delete");
            } else {
                System.out.println("Item not found!");
            }
    }

    public static void findIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter ID item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item with Id " + id + " not found!");
        }
    }

    public static void findNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items with name " + name + " not found!");
        }
    }*/

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: "); //получаем от пользователя пункт меню.
            UserAction action = actions[select]; //параметр используем в качестве индекса в массиве
            run = action.execute(input, tracker);
        }
    }

    /*public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);

            } else if (select == 1) {
                StartUI.allItem(input, tracker);

            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);

            } else if (select == 3) {
                StartUI.deteleItem(input, tracker);

            } else if (select == 4) {
                StartUI.findIdItem(input, tracker);

            } else if (select == 5) {
                StartUI.findNameItem(input, tracker);

            } else if (select == 6) {
                run = false;

            } else if (select > 6) {
                System.out.println("Wrong choice!!!");
            }
        }
    }*/
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new AllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindIdAction(),
                new FindNameAction(),
        };
        new StartUI().init(input, tracker, actions);
    }

/*    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println();
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }*/
}