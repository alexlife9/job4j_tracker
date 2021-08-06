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
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Alex"),
                new Item("Stas")
        );
        List<Item> rsl = Arrays.asList(
                new Item("Alex"),
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Stas")
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByNameUp());
        assertEquals(rsl, sorted);
    }

    @Test
    public void whenSortByNameDawn() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Alex"),
                new Item("Stas")
        );
        List<Item> rsl = Arrays.asList(
                new Item("Stas"),
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Alex")
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByNameDown());
        assertEquals(rsl, sorted);
    }
}
