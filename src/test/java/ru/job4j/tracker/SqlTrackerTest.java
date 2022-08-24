package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Liquibase. Интеграционные тесты
 *
 * @author Alex_life
 * @version 1.0
 * @since 23.08.2022
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
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

}

