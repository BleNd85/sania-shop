package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.cart.CartEntry;
import com.example.saniashop.dto.cart.CartEntryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CartEntryServiceMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "quantity", source = "quantity")
    CartEntryDto toCartEntryDto(CartEntry cartEntry);

    List<CartEntryDto> toCartEntryDto(List<CartEntry> cartEntries);

}
