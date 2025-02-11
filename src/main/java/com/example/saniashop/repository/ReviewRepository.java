package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.ProductReviewEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends NaturalIdRepository<ProductReviewEntity, UUID> {

    List<ProductReviewEntity> findByProductId(UUID productId);

    List<ProductReviewEntity> findByUserId(UUID userId);
}
