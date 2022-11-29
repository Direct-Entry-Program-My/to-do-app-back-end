package lk.ijse.dep9.service.custom;

import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.SuperService;
import lk.ijse.dep9.service.exception.AlreadyInUseException;
import lk.ijse.dep9.service.exception.DuplicateException;
import lk.ijse.dep9.service.exception.NotFoundException;

public interface UserService extends SuperService {

    void createNewUser(UserDTO dto) throws DuplicateException;

    void removeUser(String userName) throws AlreadyInUseException, NotFoundException;

    UserDTO getUserDetails(String userName) throws NotFoundException;

}
