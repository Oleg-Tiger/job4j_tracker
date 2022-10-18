package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFindByNameActionCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("name");
        Item item2 = new Item("name");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(new Item("Имя"));
        FindByNameAction action = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("name");

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Search items by name ===" + ln
                        + item + ln + item2 + ln)
        );
    }

    @Test
    public void whenFindByNameActionNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("name"));
        FindByNameAction action = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Имя");

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Search items by name ===" + ln
                        + "Items with entered name was not found" + ln)
        );
    }

}