package lk.ijse.dep9.dao.custom.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {

    private Connection connection;
    private UserDAOImpl userDAOImpl;


    @BeforeEach
    void setUp() throws URISyntaxException, IOException {


        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:todo_db");
            List<String> lines = Files.readAllLines(Paths.get(this.getClass().getResource("/dbscript.sql").toURI()));
            String dbScriptContent = lines.stream().reduce((pre, curr) -> pre + '\n' + curr).get();

            Statement stm = connection.createStatement();
            stm.execute(dbScriptContent);

            this.userDAOImpl = new UserDAOImpl(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @AfterEach
    void tearDown() throws SQLException {
        connection.close();

    }

    @Test
    void count() {

        long count = userDAOImpl.count();
        assertEquals(4,count);
    }

    @Test
    void deleteById() {
    }

    @Test
    void existById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}