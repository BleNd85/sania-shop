package com.example.saniashop.service.implementation;

import com.example.saniashop.domain.cart.Cart;
import com.example.saniashop.domain.common.Role;
import com.example.saniashop.domain.user.User;
import com.example.saniashop.dto.user.UserDataDto;
import com.example.saniashop.repository.CartRepository;
import com.example.saniashop.repository.UserRepository;
import com.example.saniashop.repository.entity.UserEntity;
import com.example.saniashop.repository.mapper.CartRepositoryMapper;
import com.example.saniashop.repository.mapper.UserRepositoryMapper;
import com.example.saniashop.service.UserService;
import com.example.saniashop.service.exception.user.UserNotFoundException;
import com.example.saniashop.service.exception.user.UserOldPasswordException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserRepositoryMapper userRepositoryMapper;
    private final CartRepository cartRepository;
    private final CartRepositoryMapper cartRepositoryMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImplementation(UserRepository userRepository, UserRepositoryMapper userRepositoryMapper, CartRepository cartRepository, CartRepositoryMapper cartRepositoryMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRepositoryMapper = userRepositoryMapper;
        this.cartRepository = cartRepository;
        this.cartRepositoryMapper = cartRepositoryMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepositoryMapper.toUser(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(UUID id) {
        return userRepositoryMapper.toUser(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByEmail(String email) {
        return userRepositoryMapper.toUser(userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email)));
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void saveUser(User user) {
        user.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        user.setRoles(Collections.singletonList(Role.USER));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Cart userCart = Cart.builder()
                .id(UUID.randomUUID())
                .user(user)
                .build();
        cartRepository.save(cartRepositoryMapper.toCartEntity(userCart));
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void updateUser(UUID id, UserDataDto updateUserData) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if (bCryptPasswordEncoder.matches(updateUserData.getPassword(), existingUser.getPassword())) {
            throw new UserOldPasswordException();
        }

        existingUser.setName(updateUserData.getName());
        existingUser.setSecondName(updateUserData.getSecondName());
        existingUser.setPassword(bCryptPasswordEncoder.encode(updateUserData.getPassword()));
        userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
