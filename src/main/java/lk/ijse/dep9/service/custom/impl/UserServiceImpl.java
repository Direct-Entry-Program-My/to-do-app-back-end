package lk.ijse.dep9.service.custom.impl;

import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.custom.UserService;
import lk.ijse.dep9.service.exception.AlreadyInUseException;
import lk.ijse.dep9.service.exception.DuplicateException;
import lk.ijse.dep9.service.exception.NotFoundException;

public class UserServiceImpl implements UserService {


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
