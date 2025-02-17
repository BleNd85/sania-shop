package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.common.Role;
import com.example.saniashop.domain.user.User;
import com.example.saniashop.dto.user.UserDataDto;
import com.example.saniashop.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    UserDto toUserDto(User user);

    List<UserDto> toUserDto(List<User> users);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "roles", qualifiedByName = "userRole", ignore = true)
    @Mapping(target = "cart", ignore = true)
    User toUser(UserDataDto userDto);

    List<User> toUser(List<UserDataDto> userDtos);

    @Named("userRole")
    default List<Role> userRole() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);
        return roles;
    }
}
