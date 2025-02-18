package com.example.saniashop.service.mapper;

import com.example.saniashop.domain.product.Product;
import com.example.saniashop.dto.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductServiceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "productCategory", source = "productCategory")
    @Mapping(target = "description", source = "description")
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDto(List<Product> products);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "productCategory", source = "productCategory")
    @Mapping(target = "description", source = "description")
    Product toProduct(ProductDto productDto);

    List<Product> toProduct(List<ProductDto> productDtoList);
}
