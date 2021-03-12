package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item application = new Item("Имя заявки");
        tracker.add(application);
        if (tracker.findById(1) != null) {
            System.out.println("id1 " + tracker.findById(1).getName());
        } else {
            System.out.println("Заявки c id1 не существует");
        }
    }
}
