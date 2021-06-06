package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

/*    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker(); //Создаем объект tracker.
        Item item = new Item("new item"); //Создаем объект item.
        tracker.add(item); // Добавляем item в tracker. После этой операции у нас есть id.
        String[] answers = {//Достаем item.id и создаем массив с ответами пользователя.
                String.valueOf(item.getId()), *//* id сохраненной заявки в объект tracker. *//*
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker); //Вызываем  метод replaceItem
        Item replaced = tracker.findById(item.getId()); //Ищем по item.id замененный item
        assertThat(replaced.getName(), is("replaced item")); //Сравниваем имя заявки с ожидаемой
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker(); //Создаем объект tracker.
        Item item = new Item("new item"); //Создаем объект item.
        tracker.add(item); // Добавляем item в tracker. После этой операции у нас есть id.
        String[] answers = {//Достаем item.id и создаем массив с ответами пользователя.
                String.valueOf(item.getId())};
        StartUI.deteleItem(new StubInput(answers), tracker); //Вызываем  метод deteleItem
        Item deleted = tracker.findById(item.getId()); //Ищем по item.id удаленный item
        assertThat(deleted, is(nullValue())); //Сравниваем Id заявки с ожидаемой
    }*/
}