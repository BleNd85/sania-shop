package com.example.saniashop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDataDto {
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

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String confirmPassword;
}
