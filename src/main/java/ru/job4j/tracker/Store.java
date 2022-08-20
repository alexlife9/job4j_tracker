package ru.job4j.tracker;

import java.util.List;

/**
 * @author Alex_life
 * @version 1.0
 * @since 20.08.2022
 */
public interface Store {
    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}