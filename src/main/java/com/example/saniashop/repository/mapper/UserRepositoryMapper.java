package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.common.Role;
import com.example.saniashop.domain.user.User;
import com.example.saniashop.repository.entity.RoleEntity;
import com.example.saniashop.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoles")
    @Mapping(target = "cart", source = "cart")
    User toUser(UserEntity userEntity);

    List<User> toUser(List<UserEntity> userEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "cart", source = "cart")
    UserEntity toUserEntity(User user);

    List<UserEntity> toUserEntities(List<User> users);

    @Named("mapRoles")
    default List<Role> mapRoles(List<RoleEntity> roleEntities) {
        if (roleEntities == null) {
            return List.of();
        }
        return roleEntities.stream()
                .map(roleEntity -> Role.valueOf(roleEntity.getName().toUpperCase()))
                .collect(Collectors.toList());
    }


}
