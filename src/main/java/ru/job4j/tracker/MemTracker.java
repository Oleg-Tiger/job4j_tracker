package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemsKeyMatches = new ArrayList<>();
      for (Item item : items) {
          if (item.getName().equals(key)) {
              itemsKeyMatches.add(item);
          }
      }
        return List.copyOf(itemsKeyMatches);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean accept = index != -1;
        if (accept) {
            item.setId(id);
            items.set(index, item);
        }
    return accept;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean accept = index != -1;
        if (accept) {
                items.remove(index);
            }

        return accept;
    }

    @Override
    public void close() throws Exception {

    }
}