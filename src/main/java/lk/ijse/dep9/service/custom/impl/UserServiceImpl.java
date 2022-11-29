package lk.ijse.dep9.service.custom.impl;

import lk.ijse.dep9.dao.DAOFactory;
import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.custom.UserService;
import lk.ijse.dep9.service.exception.AlreadyInUseException;
import lk.ijse.dep9.service.exception.DuplicateException;
import lk.ijse.dep9.service.exception.NotFoundException;
import lk.ijse.dep9.service.util.Converter;

public class UserServiceImpl implements UserService {

    private final Converter converter;

    private UserDAO userDAO;

    public UserServiceImpl() {

        this.converter = new Converter();
        userDAO = DAOFactory.getInstance().getDAO(ConnectionU)
    }

    @Override
    public void createNewUser(UserDTO dto) throws DuplicateException {

    }

    @Override
    public void removeUser(String userName) throws AlreadyInUseException, NotFoundException {

    }

    @Override
    public UserDTO getUserDetails(String userName) throws NotFoundException {
        return null;
    }
}
