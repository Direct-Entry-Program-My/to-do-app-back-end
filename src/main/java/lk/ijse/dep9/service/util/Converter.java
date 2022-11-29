package lk.ijse.dep9.service.util;


import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;



public class Converter {

    private ModelMapper mapper;
    public Converter() {

        this.mapper = new ModelMapper();


    }


    public User toUser(UserDTO userDTO){
        return mapper.map(userDTO,User.class);
    }

    public UserDTO fromUser(User user){
        return mapper.map(user,UserDTO.class);
    }

}
