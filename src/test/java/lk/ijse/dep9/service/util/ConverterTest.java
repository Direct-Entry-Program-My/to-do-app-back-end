package lk.ijse.dep9.service.util;

import com.github.javafaker.Faker;
import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    private Converter converter =new Converter();

    @Test
    void toUser() {

        Faker faker = new Faker();

        UserDTO userDTO = new UserDTO(faker.regexify("u\\d{3}"), faker.code().asin(), faker.name().fullName());

        User userEntity = converter.toUser(userDTO);

        assertEquals(userDTO.getUser_name(),userEntity.getUser_name());
        assertEquals(userDTO.getPassword(),userEntity.getPassword());
        assertEquals(userDTO.getFull_name(),userEntity.getFull_name());


    }

    @Test
    void fromUser() {

        Faker faker = new Faker();

        User userEntity = new User(faker.regexify("u\\d{3}"), faker.code().asin(), faker.name().fullName());

        UserDTO userDTO = converter.fromUser(userEntity);

        assertEquals(userEntity.getUser_name(),userDTO.getUser_name());
        assertEquals(userEntity.getPassword(),userDTO.getPassword());
        assertEquals(userEntity.getFull_name(),userDTO.getFull_name());
    }
}