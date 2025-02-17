package com.example.saniashop.service;


import com.example.saniashop.domain.product.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory getProductCategoryById(Long id);

    List<ProductCategory> getAllProductCategories();

    List<ProductCategory> getAllTopProductCategories();

    List<ProductCategory> getProductCategoryByName(String categoryName);

    List<ProductCategory> getSubCategoriesByTopCategoryId(Long topCategoryId);

    void saveProductCategory(ProductCategory productCategory, Long parentCategoryId);

    void updateProductCategory(ProductCategory productCategory, Long parentCategoryId);

    void deleteProductCategory(Long id);

}
