package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAllItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Test1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1"));
        UserAction[] actions = {
                new CreateAction(out),
                new AllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Enter name: " + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "1. === Show all items ====" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}

        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindNameAction(out), new ExitAction(out)
        };

    }

    @Test
    public void whenFindById() {

    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }
}