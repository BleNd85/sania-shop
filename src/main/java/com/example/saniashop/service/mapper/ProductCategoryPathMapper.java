package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.product.ProductCategory;

import com.example.saniashop.dto.product.ProductCategoryPathDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryPathMapper {

    @Mapping(target = "slug", source = "slug")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProductCategoryPathDto toProductCategoryDataDto(ProductCategory category);

    List<ProductCategoryPathDto> toProductCategoryDataDto(List<ProductCategory> categories);
}

