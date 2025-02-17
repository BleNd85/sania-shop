package com.example.saniashop.service.exception.user;


public class UserOldPasswordException extends RuntimeException {
    private static final String PASSWORD_OLD_PASSWORD = "Password must not be the same as the old password";

    public UserOldPasswordException() {
        super(PASSWORD_OLD_PASSWORD);
    }
}
