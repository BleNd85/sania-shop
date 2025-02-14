package com.example.saniashop.service;

import com.example.saniashop.domain.product.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(UUID id);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByDescription(String description);

    List<Product> getProductsByPriceRange(Integer min, Integer max);

    List<Product> getProductsByCategory(Long categoryId);

}
