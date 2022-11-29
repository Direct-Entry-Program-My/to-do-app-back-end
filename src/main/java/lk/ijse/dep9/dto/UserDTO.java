package lk.ijse.dep9.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    @Pattern(regexp = "u\\d{3}")
    private String user_name;

    @NotBlank
    private String password;

    @NotBlank
    @Pattern(regexp = "[A-Za-z ]+")
    private String full_name;


}
