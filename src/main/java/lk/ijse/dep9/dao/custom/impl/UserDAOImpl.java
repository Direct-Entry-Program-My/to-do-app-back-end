package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    } //Done

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

    } //Done

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


    } //Done

    @Override
    public List findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM User");
            ResultSet rst = stm.executeQuery();

            ArrayList<User> users = new ArrayList<>();

            while (rst.next()){
                String user_name = rst.getString("user_name");
                String full_name = rst.getString("full_name");
                String password = rst.getString("password");

                users.add(new User(user_name,password,full_name));
            }

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } //Done

    @Override
    public Optional<User> getById(String userName) {

        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM User WHERE user_name = ?");
            stm.setString(1,userName);

            ResultSet rst = stm.executeQuery();

            if (rst.next()) {
                return Optional.of(new User(rst.getString("user_name"),rst.getString("password"),rst.getString("full_name")));
            } else {

                return Optional.empty();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    } //Done

    @Override
    public User save(User user) {

        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO User(user_name, password, full_name) VALUES (?,?,?)");
            stm.setString(1, user.getUser_name());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getFull_name());

            if (stm.executeUpdate() ==1){
                return user;
            }else throw new SQLException("Failed to save the new User");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User update(User user) {




    }
}


