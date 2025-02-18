package com.example.saniashop.service.implementation;

import com.example.saniashop.domain.product.Product;
import com.example.saniashop.repository.ProductRepository;
import com.example.saniashop.repository.mapper.ProductRepositoryMapper;
import com.example.saniashop.service.ProductCategoryService;
import com.example.saniashop.service.ProductService;
import com.example.saniashop.service.exception.product.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final ProductRepositoryMapper productRepositoryMapper;

    public ProductServiceImplementation(ProductRepository productRepository, ProductRepositoryMapper productRepositoryMapper) {
        this.productRepository = productRepository;
        this.productRepositoryMapper = productRepositoryMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryMapper.toProduct(productRepository.findAll());
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepositoryMapper.toProduct(productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public List<Product> getProductsByNameOrDescription(String keyword) {
        return productRepositoryMapper.toProduct(productRepository
                .findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(keyword, keyword));
    }

    @Override
    public List<Product> getProductsByPriceRange(Integer min, Integer max) {
        return productRepositoryMapper.toProduct(productRepository.findByPriceIsBetween(min, max));
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepositoryMapper.toProduct(productRepository.findByCategoryId(categoryId));
    }

    @Override
    public List<Product> getProductsByCategoryAndNameOrDescription(Long categoryId, String keyword) {
        return productRepositoryMapper.toProduct(productRepository
                .findByCategoryIdAndNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(categoryId, keyword, keyword));
    }
}
