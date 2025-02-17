package com.example.saniashop.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordMatchValidation.class})
@Documented
public @interface ValidPassword {

    String message() default "Password doesn't match confirmation password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
