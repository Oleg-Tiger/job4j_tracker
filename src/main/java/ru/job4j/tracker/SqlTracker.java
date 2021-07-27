package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream(
                "app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement(
                "insert into items(name, created) values(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "update items set name = ?, created = ? where id = ?"
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rsl.add(new Item(
                            rs.getString("name"),
                            rs.getInt("id"),
                            rs.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        String sql = String.format("select * from items where name = \'%s\'", key);
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rsl.add(new Item(
                            rs.getString("name"),
                            rs.getInt("id"),
                            rs.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        String sql = String.format("select * from items where id = %s", id);
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rsl = new Item(
                            rs.getString("name"),
                            rs.getInt("id"),
                            rs.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl;
    }
}