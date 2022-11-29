package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {


    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(user_name) AS count FROM User");
            ResultSet rst = stm.executeQuery();

            return rst.getInt("count");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String userName) {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM User WHERE user_name = ?");
            if (stm.executeUpdate() == 1) {
                return;
            } else {
                throw new SQLException("Failed to delete the User");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existById(String userName) {

        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM User WHERE user_name = ?");
            stm.setString(1, userName);
            ResultSet rst = stm.executeQuery();

            return rst.next();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional<User> getById(String PK) {
        return Optional.empty();
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}


