package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        //Item item = items.get(index);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        //return index != -1 ? items[index] : null;
        return index != 0 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        //Item[] namesWithKey = new Item[this.size];
        //for (int i = 0; i < size; i++) {
            //Item item = items[i];
            //if (item.getName().equals(key)) {
                //namesWithKey[count++] = item;
        List<Item> itemsList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsList.add(item);
            }
        }
        return itemsList;
    }

    public List<Item> findAll() {
        //return Arrays.copyOf(items, size);
        return List.copyOf(items);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }
}