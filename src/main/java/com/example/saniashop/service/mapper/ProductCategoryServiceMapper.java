package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.dto.product.ProductCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductCategoryServiceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "parentCategory", source = "parentCategory")
    @Mapping(target = "subCategories", source = "subCategories")
    ProductCategoryDto toProductCategoryDto(ProductCategory productCategory);

    List<ProductCategoryDto> toProductCategoryDto(List<ProductCategory> productCategories);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "parentCategory", source = "parentCategory")
    @Mapping(target = "subCategories", source = "subCategories")
    ProductCategory toProductCategory(ProductCategoryDto productCategoryDto);

    List<ProductCategory> toProductCategory(List<ProductCategoryDto> productCategoryDtos);
}
