package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortByNameTest {
    @Test
    public void whenSortByNameUp() {
        List<Item> items = List.of(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Alex"),
                new Item("Stas")
        );
        List<Item> rsl = List.of(
                new Item("Alex"),
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Stas")
        );
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort(new SortByNameUp());
        assertEquals(rsl, sorted);
    }

    @Test
    public void whenSortByNameDawn() {
        List<Item> items = List.of(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Alex"),
                new Item("Stas")
        );
        List<Item> rsl = List.of(
                new Item("Stas"),
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Alex")
        );
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort(new SortByNameDown());
        assertEquals(rsl, sorted);
    }
}
