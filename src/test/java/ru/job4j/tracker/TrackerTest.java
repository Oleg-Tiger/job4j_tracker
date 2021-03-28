package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void WhenSortedByIdMinToMax() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item("name1", 333);
        Item item2 = new Item("name2", 3);
        Item item3 = new Item("name3", 33);
        list.add(item3);
        list.add(item1);
        list.add(item2);
        Collections.sort(list, new SortByIdItemMinToMax());
        assertThat(list, is(Arrays.asList(item2, item3, item1)));
    }

    @Test
    public void WhenSortedByIdMaxToMin() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item("name1", 333);
        Item item2 = new Item("name2", 3);
        Item item3 = new Item("name3", 33);
        list.add(item3);
        list.add(item1);
        list.add(item2);
        Collections.sort(list, new SortByIdItemMaxToMin());
        assertThat(list, is(Arrays.asList(item1, item3, item2)));
    }

    @Test
    public void WhenSortedByNameMinToMax() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item("name1", 333);
        Item item2 = new Item("name2", 3);
        Item item3 = new Item("name3", 33);
        list.add(item3);
        list.add(item1);
        list.add(item2);
        Collections.sort(list, new SortByNameItemMinToMax());
        assertThat(list, is(Arrays.asList(item1, item2, item3)));
    }

    @Test
    public void WhenSortedByNameMaxToMin() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item("name1", 333);
        Item item2 = new Item("name2", 3);
        Item item3 = new Item("name3", 33);
        list.add(item3);
        list.add(item1);
        list.add(item2);
        Collections.sort(list, new SortByNameItemMaxToMin());
        assertThat(list, is(Arrays.asList(item3, item2, item1)));

    }

}