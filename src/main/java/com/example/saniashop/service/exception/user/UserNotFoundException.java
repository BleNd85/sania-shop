package com.example.saniashop.service.exception.user;


import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    private static final String USER_NOT_FOUND_MESSAGE = "User with id %s not found";
    private static final String USER_NOT_FOUND_MESSAGE_EMAIL = "User with email %s not found";

    public UserNotFoundException(String email) {
        super(String.format(USER_NOT_FOUND_MESSAGE_EMAIL, email));
    }

    public UserNotFoundException(UUID id) {
        super(String.format(USER_NOT_FOUND_MESSAGE, id));
    }
}
