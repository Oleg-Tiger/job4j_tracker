package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDeleteActionCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Removed item"));
        DeleteAction action = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Completed" + ln));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteActionNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Removed item"));
        DeleteAction action = new DeleteAction(out);

        Input input = mock(Input.class);

        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Delete item ===" + ln
                        + "The item with entered id was not found" + ln)
        );
        assertThat(tracker.findAll().get(0).getName(), is("Removed item"));
    }
}