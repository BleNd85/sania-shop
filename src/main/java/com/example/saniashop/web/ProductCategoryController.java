package com.example.saniashop.web;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.dto.product.ProductCategoryDto;
import com.example.saniashop.service.ProductCategoryService;
import com.example.saniashop.service.mapper.ProductCategoryServiceMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryServiceMapper productCategoryServiceMapper;

    public ProductCategoryController(ProductCategoryService productCategoryService, ProductCategoryServiceMapper productCategoryServiceMapper) {
        this.productCategoryService = productCategoryService;
        this.productCategoryServiceMapper = productCategoryServiceMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> findAll() {
        return ResponseEntity.ok(productCategoryServiceMapper.toProductCategoryDto(productCategoryService.getAllProductCategories()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam String name, @RequestParam(required = false) Long id) {
        ProductCategory productCategory = ProductCategory.builder().name(name).build();
        productCategoryService.saveProductCategory(productCategory, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
