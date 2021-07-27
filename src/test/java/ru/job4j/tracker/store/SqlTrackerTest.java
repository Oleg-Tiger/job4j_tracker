package ru.job4j.tracker.store;

import org.junit.*;
import ru.job4j.tracker.SqlTracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream(
                "test.properties"
        )) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItemAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName("item").get(0), is(item));
        Item newItem = new Item("newitem");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is(newItem.getName()));
        assertThat(tracker.findById(item.getId()).getCreated().withNano(0),
                is(newItem.getCreated().withNano(0)));

    }

    @Test
    public void whenDeleteAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item2);
        List<Item> expected = new ArrayList<>(Arrays.asList(item, item2));
        Assert.assertThat(tracker.findAll(), is(expected));
        tracker.delete(item2.getId());
        assertNull(tracker.findById(item2.getId()));
    }

}