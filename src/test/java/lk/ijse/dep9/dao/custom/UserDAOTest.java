package lk.ijse.dep9.dao.custom;

import com.github.javafaker.Faker;
import lk.ijse.dep9.dao.DAOFactory;
import lk.ijse.dep9.dao.DAOTypes;
import lk.ijse.dep9.dao.custom.impl.UserDAOImpl;
import lk.ijse.dep9.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private Connection connection;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() throws URISyntaxException, IOException {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:");
            List<String> lines = Files.readAllLines(Paths.get(this.getClass().getResource("/dbscript.sql").toURI()));
            String dbScriptContent = lines.stream().reduce((pre, curr) -> pre + '\n' + curr).get();

            Statement stm = connection.createStatement();
            stm.execute(dbScriptContent);

            this.userDAO = DAOFactory.getInstance().getDAO(connection,DAOTypes.USER);

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

        long count = userDAO.count();
        assertEquals(4,count);
    }

    @Test
    void deleteById() {


        userDAO.deleteById("u002");







    }

    @Test
    void existById() {

        assertTrue(userDAO.existById("u001"));
        assertFalse(userDAO.existById("000"));
    }

    @Test
    void findAll() {

        List<User> all = userDAO.findAll();
        assertEquals(4,all.size());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/user-test-data.csv")
    void getById(String memberId) {
        Optional<User> byId = userDAO.getById(memberId);
//        assertEquals(memberId,byId.get().getUser_name());

    }

    @Test
    void save() {
        Faker faker = new Faker();
        User expected = new User(faker.regexify("u\\d{3}"), faker.code().asin(), faker.name().fullName());
        User actual = userDAO.save(expected);
        assertEquals(expected,actual);

    }

    @Test
    void update() {

        Faker faker = new Faker();

        Optional<User> user = userDAO.getById("u001");



        user.ifPresent(u->{
            u.setFull_name(faker.name().fullName());
            u.setPassword(faker.code().asin());
            User update = userDAO.update(u);

            assertEquals(user,update);

        });



    }
}