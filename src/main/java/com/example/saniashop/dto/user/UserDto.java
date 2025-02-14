package com.example.saniashop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Email is mandatory")
    @Size(max = 50)
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 25)
    private String name;

    @NotBlank(message = "Second name is mandatory")
    @Size(max = 25)
    private String secondName;

    private Timestamp registrationDate;

}
