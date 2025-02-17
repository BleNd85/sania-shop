package com.example.saniashop.dto.validation;

import com.example.saniashop.dto.user.UserDataDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidation implements ConstraintValidator<ValidPassword, UserDataDto> {

    @Override
    public boolean isValid(UserDataDto user, ConstraintValidatorContext constraintValidatorContext) {
        if (user.getPassword() == null || user.getConfirmPassword() == null) {
            return false;
        }
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
