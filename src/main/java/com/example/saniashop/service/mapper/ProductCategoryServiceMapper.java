package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.dto.product.ProductCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryServiceMapper {

    @Mapping(target = "slug", source = "slug")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "subCategories", source = "subCategories")
    ProductCategoryDto toProductCategoryDto(ProductCategory productCategory);

    List<ProductCategoryDto> toProductCategoryDto(List<ProductCategory> productCategories);

    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "parentCategory", ignore = true)
    @Mapping(target = "subCategories", source = "subCategories")
    ProductCategory toProductCategory(ProductCategoryDto productCategoryDto);

    List<ProductCategory> toProductCategory(List<ProductCategoryDto> productCategoryDtos);
}
