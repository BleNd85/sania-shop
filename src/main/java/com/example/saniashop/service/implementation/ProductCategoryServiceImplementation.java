package com.example.saniashop.service.implementation;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.repository.ProductCategoryRepository;
import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.mapper.ProductCategoryRepositoryMapper;
import com.example.saniashop.service.ProductCategoryService;
import com.example.saniashop.service.exception.category.CategoryNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryRepositoryMapper productCategoryRepositoryMapper;

    public ProductCategoryServiceImplementation(ProductCategoryRepository productCategoryRepository, ProductCategoryRepositoryMapper productCategoryRepositoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryRepositoryMapper = productCategoryRepositoryMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductCategory getProductCategoryById(Long id) {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getAllTopProductCategories() {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findByParentCategoryIsNull());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getProductCategoryByName(String name) {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findByName(name));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getSubCategoriesByTopCategoryId(Long parentCategoryId) {
        CategoryEntity parentCategory = productCategoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(parentCategoryId));
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findByParentCategory(parentCategory));
    }

    @Override
    @Transactional
    public void saveProductCategory(ProductCategory productCategory, Long parentCategoryId) {
        CategoryEntity parentCategory = null;
        if (parentCategoryId != null) {
            parentCategory = productCategoryRepository.findById(parentCategoryId)
                    .orElseThrow(() -> new CategoryNotFoundException(parentCategoryId));
        }
        productCategory.setParentCategory(productCategoryRepositoryMapper.toProductCategory(parentCategory));
        productCategoryRepository.save(productCategoryRepositoryMapper.toCategoryEntity(productCategory));
    }

    @Override
    @Transactional
    public void updateProductCategory(ProductCategory productCategory, Long parentCategoryId) {
        CategoryEntity oldCategory = productCategoryRepository.findById(productCategory.getId())
                .orElseThrow(() -> new CategoryNotFoundException(productCategory.getId()));
        oldCategory.setName(productCategory.getName());
        oldCategory.setParentCategory(productCategoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(parentCategoryId)));
        productCategoryRepository.save(oldCategory);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
