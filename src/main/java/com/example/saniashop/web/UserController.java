package com.example.saniashop.web;

import com.example.saniashop.dto.user.UserDataDto;
import com.example.saniashop.dto.user.UserDto;
import com.example.saniashop.service.UserService;
import com.example.saniashop.service.mapper.UserServiceMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final UserServiceMapper userServiceMapper;

    public UserController(UserService userService, UserServiceMapper userServiceMapper) {
        this.userService = userService;
        this.userServiceMapper = userServiceMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userServiceMapper.toUserDto(userService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userServiceMapper.toUserDto(userService.getUserById(id)));
    }

    @GetMapping("/email")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userServiceMapper.toUserDto(userService.getUserByEmail(email)));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDataDto userDto) {
        userService.saveUser(userServiceMapper.toUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable UUID id, @Valid @RequestBody UserDataDto userDataDto) {
        userService.updateUser(id, userDataDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
