package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowEmpty() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ShowAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Show all items"
              +  System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "===  Show all items ===" + System.lineSeparator()
               + "Items not found" + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenFindByIdEmpty() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "100", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Find item by Id"
                + System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "=== Search item by id ===" + System.lineSeparator()
               + "The item with entered id was not found" + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenFindByNameEmpty() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "name", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Find items by name"
                + System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "=== Search items by name ===" + System.lineSeparator()
               + "Items with entered name was not found" + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenShow() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name"));
        List<UserAction> actions = Arrays.asList(new ShowAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Show all items"
               + System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "===  Show all items ===" + System.lineSeparator()
               + item + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "2", "1"});
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name"));
        Item item2 = tracker.add(new Item("name2"));
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Find item by Id"
                + System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "=== Search item by id ===" + System.lineSeparator()
               + item2 + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "name2", "1"});
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name"));
        Item item2 = tracker.add(new Item("name2"));
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String result1 = "Menu." + System.lineSeparator() + "0. Find items by name"
                + System.lineSeparator() + "1. Exit Program" + System.lineSeparator();
        String result2 = "=== Search items by name ===" + System.lineSeparator()
              +  item2 + System.lineSeparator();
        assertThat(out.toString(), is(result1 + result2 + result1));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {String.valueOf(1), String.valueOf(0)});
        Store tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenInvalidInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output, new StubInput(new String[]{"one", "1"}));
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenNegativeInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output, new StubInput(new String[]{"-1"}));
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output, new StubInput(new String[]{"1", "2", "3"}));
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output, new StubInput(new String[]{"2"}));
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }
}