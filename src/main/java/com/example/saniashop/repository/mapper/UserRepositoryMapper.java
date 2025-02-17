package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.user.User;
import com.example.saniashop.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "cart", ignore = true)
    User toUser(UserEntity userEntity);

    List<User> toUser(List<UserEntity> userEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "roles", source = "roles")
    UserEntity toUserEntity(User user);

    List<UserEntity> toUserEntities(List<User> users);

}
