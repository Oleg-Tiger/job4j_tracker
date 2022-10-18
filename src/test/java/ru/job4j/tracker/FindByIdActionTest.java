package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFindByIdActionCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("name");
        tracker.add(item);
        FindByIdAction action = new FindByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Search item by id ===" + ln + item + ln));
    }

    @Test
    public void whenFindByIdActionNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("name"));
        FindByIdAction action = new FindByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Search item by id ===" + ln
                        + "The item with entered id was not found" + ln)
        );
    }

}