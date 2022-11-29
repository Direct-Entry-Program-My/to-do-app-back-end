package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.entity.ToDoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ToDoItemDAOImpl implements ToDoItemDAO {

    private final Connection connection;

    public ToDoItemDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(id) FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existById(Integer PK) {
        return false;
    }

    @Override
    public List<ToDoItem> findAll() {
        return null;
    }

    @Override
    public Optional<ToDoItem> getById(Integer PK) {
        return Optional.empty();
    }

    @Override
    public ToDoItem save(ToDoItem entity) {
        return null;
    }

    @Override
    public ToDoItem update(ToDoItem entity) {
        return null;
    }

    @Override
    public void deleteAllToDos() {

    }
}
