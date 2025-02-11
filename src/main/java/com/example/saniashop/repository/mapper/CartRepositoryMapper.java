package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.cart.Cart;
import com.example.saniashop.repository.entity.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserRepositoryMapper.class})
public interface CartRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "user")
    Cart toCart(CartEntity cartEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "user")
    CartEntity toCartEntity(Cart cart);

}
