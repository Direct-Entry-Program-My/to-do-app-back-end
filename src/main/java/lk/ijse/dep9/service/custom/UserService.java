package lk.ijse.dep9.service.custom;

import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.SuperService;

public interface UserService extends SuperService {

    void createNewUser(UserDTO dto);

    void removeUser(String userName);

    UserDTO getUserDetails(String userName);

}
