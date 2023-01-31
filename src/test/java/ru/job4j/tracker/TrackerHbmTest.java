package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerHbmTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private final Session session = sf.openSession();

    @After
    public void wipeTable() {
        try {
            session.beginTransaction();
            session.createQuery("DELETE from Item")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item);
            tracker.replace(item.getId(), item2);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item2.getName()));
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item);
            tracker.add(item2);
            List<Item> result = tracker.findAll();
            assertThat(result, is(List.of(item, item2)));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findByName(item.getName());
            assertThat(result, is(List.of(item)));
        }
    }

    @Test
    public void whenFindById() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result, is(item));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item);
            tracker.add(item2);
            tracker.delete(item.getId());
            List<Item> result = tracker.findAll();
            assertThat(result, is(List.of(item2)));
        }
    }
}