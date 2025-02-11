package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.cart.CartEntry;
import com.example.saniashop.repository.entity.CartEntryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CartRepositoryMapper.class, ProductRepositoryMapper.class})
public interface CartEntryRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cart", source = "cart")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "quantity", source = "quantity")
    CartEntry toCartEntry(CartEntryEntity cartEntryEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cart", source = "cart")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "quantity", source = "quantity")
    CartEntryEntity toCartEntryEntity(CartEntry cartEntry);

}
