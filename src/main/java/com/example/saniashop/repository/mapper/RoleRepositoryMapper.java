package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.user.RoleDetails;
import com.example.saniashop.repository.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserRepositoryMapper.class})
public interface RoleRepositoryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "users", target = "users")
    RoleDetails toRoleDetails(RoleEntity roleEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "users", target = "users")
    RoleEntity toRoleEntity(RoleDetails roledetails);
}
