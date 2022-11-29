package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.Status;
import lk.ijse.dep9.entity.ToDoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            if(existById(id)) throw new ConstraintViolationException("Member still exists in other tables", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existById(Integer id) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("SELECT id FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rst = stm.executeQuery();
            return rst.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ToDoItem> findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM ToDoItem");
            ResultSet rst = stm.executeQuery();
            List<ToDoItem> toDoItemList = new ArrayList<>();
            while(rst.next()){
                int id = rst.getInt(1);
                String username = rst.getString("user_name");
                String description = rst.getString("description");
                Status status = Status.valueOf(rst.getString("status"));
                toDoItemList.add(new ToDoItem(id, username,description,status));
            }
            return toDoItemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ToDoItem> getById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM ToDoItem WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.next()){
                String username = rst.getString("user_name");
                String description = rst.getString("description");
                Status status = Status.valueOf(rst.getString("status"));
                return Optional.of(new ToDoItem(id, username,description,status));
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO ToDoItem (user_name, description, status) VALUES (?, ?, ?)");
            stm.setString(1, toDoItem.getUserName());
            stm.setString(2, toDoItem.getDescription());
            stm.setString(3, String.valueOf(toDoItem.getStatus()));
            int affectedRows = stm.executeUpdate();
            if (affectedRows == 1){
                return toDoItem;
            }else {
                throw new SQLException("Failed to save the Issue Note");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDoItem update(ToDoItem toDoItem) {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE ToDoItem SET description = ?, status = ? WHERE id = ? OR user_name = ?");
            stm.setInt(1, toDoItem.getId());
            stm.setString(2, toDoItem.getUserName());
            if (stm.executeUpdate() == 1){
                return toDoItem;
            }else{
                throw new SQLException("Failed to update the To Do Item");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAllToDos() {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM ToDoItem");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
