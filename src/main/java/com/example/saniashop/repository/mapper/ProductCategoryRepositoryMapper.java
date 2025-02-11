package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.repository.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "parentCategory", source = "parentCategory")
    @Mapping(target = "subCategories", source = "subCategories")
    ProductCategory toProductCategory(CategoryEntity categoryEntity);

    List<ProductCategory> toProductCategory(List<CategoryEntity> categoryEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "parentCategory", source = "parentCategory")
    @Mapping(target = "subCategories", source = "subCategories")
    CategoryEntity toCategoryEntity(ProductCategory productCategory);

    List<CategoryEntity> toCategoryEntity(List<ProductCategory> productCategories);

}
