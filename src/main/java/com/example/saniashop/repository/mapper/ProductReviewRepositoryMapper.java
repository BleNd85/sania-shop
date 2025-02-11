package com.example.saniashop.repository.mapper;

import com.example.saniashop.domain.product.ProductReview;
import com.example.saniashop.repository.entity.ProductReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductRepositoryMapper.class, UserRepositoryMapper.class})
public interface ProductReviewRepositoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "created", source = "created")
    ProductReview toProductReview(ProductReviewEntity productReviewEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "created", source = "created")
    ProductReviewEntity toProductReviewEntity(ProductReview productReview);
}
