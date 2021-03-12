package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = Arrays.copyOf(items, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsKeyMatches = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (key.equals(items[i].getName())) {
                itemsKeyMatches[size++] = items[i];
            }
        }
        itemsKeyMatches = Arrays.copyOf(itemsKeyMatches, size);
        return itemsKeyMatches;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean accept = index != -1;
        if (accept) {
            items[index].setName(item.getName());
        }
    return accept;
    }
}