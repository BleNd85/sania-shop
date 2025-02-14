package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.user.User;
import com.example.saniashop.dto.user.UserDataDto;
import com.example.saniashop.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    UserDto toUserDto(User user);

    List<UserDto> toUserDto(List<User> users);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "password", source = "password")
    User toUser(UserDataDto userDto);

    List<User> toUser(List<UserDataDto> userDtos);

}
