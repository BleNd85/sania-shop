package com.example.saniashop.service.implementation;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.repository.ProductCategoryRepository;
import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.mapper.ProductCategoryRepositoryMapper;
import com.example.saniashop.service.ProductCategoryService;
import com.example.saniashop.service.exception.category.CategoryNotFoundException;
import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryRepositoryMapper productCategoryRepositoryMapper;
    private final Slugify slugify;

    public ProductCategoryServiceImplementation(ProductCategoryRepository productCategoryRepository, ProductCategoryRepositoryMapper productCategoryRepositoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryRepositoryMapper = productCategoryRepositoryMapper;
        this.slugify = Slugify.builder().build();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductCategory getProductCategoryById(Long id) {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id)));
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getAllTopProductCategories() {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findByParentCategoryIsNull());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getProductCategoryBySlug(String slug) {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findBySlug(slug));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getProductCategoryByName(String categoryName) {
        return productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findByName(categoryName));
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> getCategoryPath(Long categoryId) {
        List<ProductCategory> productCategories = productCategoryRepositoryMapper.toProductCategory(productCategoryRepository.findCategoryPath(categoryId));
        Collections.reverse(productCategories);
        return productCategories;
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
        productCategory.setSlug(slugify.slugify(productCategory.getName()));
        productCategoryRepository.save(productCategoryRepositoryMapper.toCategoryEntity(productCategory));
    }

    @Override
    @Transactional
    public void updateProductCategory(ProductCategory productCategory, Long parentCategoryId) {
        CategoryEntity oldCategory = productCategoryRepository.findById(productCategory.getId())
                .orElseThrow(() -> new CategoryNotFoundException(productCategory.getId()));

        oldCategory.setName(productCategory.getName());
        oldCategory.setSlug(slugify.slugify(productCategory.getName()));

        CategoryEntity parentCategory = (parentCategoryId != null)
                ? productCategoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(parentCategoryId))
                : null;

        oldCategory.setParentCategory(parentCategory);
        productCategoryRepository.save(oldCategory);
    }

    @Override
    @Transactional
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }


}
