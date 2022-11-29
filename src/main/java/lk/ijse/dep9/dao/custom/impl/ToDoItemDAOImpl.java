package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.entity.ToDoItem;

import java.util.List;
import java.util.Optional;

public class ToDoItemDAOImpl implements ToDoItemDAO {


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer PK) {

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
