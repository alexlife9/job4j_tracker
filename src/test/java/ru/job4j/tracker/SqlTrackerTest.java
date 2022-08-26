package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Liquibase. Интеграционные тесты
 *
 * @author Alex_life
 * @version 3.0
 * @since 26.08.2022
 */
public class SqlTrackerTest {

    /**
     * Пояснения:
     *  - на все тесты создаем одно подключение к БД, чтобы ускорить их, поэтому Connection делаем статическим;
     *
     *  - в методе initConnection() выполняется инициализация подключения.
     *  Данный метод обозначен аннотацией @BeforeClass, т.е. метод выполняется один раз до начала тестов;
     *
     *  - в методе closeConnection() выполняется закрытие подключения.
     *  Данный метод обозначен аннотацией @AfterClass, т.е. метод выполняется один раз после тестов;
     *
     *  - в методе wipeTable() мы чистим таблицу items после внесенных изменений.
     *  Делается это специально, чтобы облегчить тестирование, иначе изменения, внесенные один тестом,
     *  будут видны другому. Данный метод обозначен аннотацией @After, т.е. метод выполняется после каждого теста;
     *
     *  - метод whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() представляет собой уже тест.
     *  Обратите внимание, что после вставки мы находим item по сгенерированному БД ключу.
     *
     *  Важно! В тесте сравниваются сами заявки, а это значит что должны быть переопределены equals() & hashCode().
     */

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver"));
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
        Item item = tracker.add(new Item("item"));
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item1 = new Item("item1");
        assertTrue(tracker.replace(item.getId(), item1));
        assertThat(tracker.findById(item.getId()).getName(), is(item1.getName()));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item2 = tracker.add(new Item("item2"));
        assertTrue(tracker.delete(item2.getId()));
        assertThat(tracker.findById(item2.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findAll(), is(List.of(item1, item2, item3)));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findByName(item3.getName()), is(List.of(item3)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findById(item3.getId()), is(List.of(item3)));
    }
}

