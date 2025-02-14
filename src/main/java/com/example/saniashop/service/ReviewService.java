package com.example.saniashop.service;

import com.example.saniashop.domain.product.ProductReview;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    List<ProductReview> getAllReviewsByProductId(UUID productId);

    List<ProductReview> getAllReviewsByUserId(UUID userId);

}
