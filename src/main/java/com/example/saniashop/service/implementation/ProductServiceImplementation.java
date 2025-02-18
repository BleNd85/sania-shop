package com.example.saniashop.service.implementation;

import com.example.saniashop.domain.product.Product;
import com.example.saniashop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByDescription(String description) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByPriceRange(Integer min, Integer max) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return List.of();
    }
}
