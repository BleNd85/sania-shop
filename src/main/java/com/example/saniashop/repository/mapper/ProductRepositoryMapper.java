package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.product.Product;
import com.example.saniashop.repository.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductCategoryRepositoryMapper.class})
public interface ProductRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "productCategory", source = "category")
    @Mapping(target = "description", source = "description")
    Product toProduct(ProductEntity productEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category", source = "productCategory")
    @Mapping(target = "description", source = "description")
    ProductEntity toProductEntity(Product product);
}
