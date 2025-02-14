package com.example.saniashop.service;

import com.example.saniashop.domain.user.User;

import java.util.List;
import java.util.UUID;


public interface UserService {

    List<User> getAll();

    User getUserById(UUID id);

    User getUserByEmail(String email);

    void saveUser(User user);

    void deleteUser(UUID id);

}
