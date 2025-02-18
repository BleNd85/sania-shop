package com.example.saniashop.web;

import com.example.saniashop.domain.product.ProductCategory;
import com.example.saniashop.dto.product.ProductCategoryDto;
import com.example.saniashop.dto.product.ProductCategoryPathDto;
import com.example.saniashop.service.ProductCategoryService;
import com.example.saniashop.service.mapper.ProductCategoryPathMapper;
import com.example.saniashop.service.mapper.ProductCategoryServiceMapper;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryServiceMapper productCategoryServiceMapper;
    private final ProductCategoryPathMapper productCategoryPathMapper;

    public ProductCategoryController(ProductCategoryService productCategoryService, ProductCategoryServiceMapper productCategoryServiceMapper, ProductCategoryPathMapper productCategoryPathMapper) {
        this.productCategoryService = productCategoryService;
        this.productCategoryServiceMapper = productCategoryServiceMapper;
        this.productCategoryPathMapper = productCategoryPathMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> findTopCategories() {
        return ResponseEntity.ok(productCategoryServiceMapper.toProductCategoryDto(productCategoryService.getAllTopProductCategories()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDto> findProductCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryServiceMapper.toProductCategoryDto(productCategoryService.getProductCategoryById(id)));
    }

    @GetMapping("/path/{id}")
    public ResponseEntity<List<ProductCategoryPathDto>> findCategoryPath(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryPathMapper.toProductCategoryDataDto(productCategoryService.getCategoryPath(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductCategoryDto>> findProductCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(productCategoryServiceMapper.toProductCategoryDto(productCategoryService.getProductCategoryByName(name)));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<List<ProductCategoryDto>> findProductCategoryBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(productCategoryServiceMapper.toProductCategoryDto(productCategoryService.getProductCategoryBySlug(slug)));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam @Size(max = 25) String name, @RequestParam(required = false) Long id) {
        ProductCategory productCategory = ProductCategory.builder().name(name).build();
        productCategoryService.saveProductCategory(productCategory, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestParam @Size(max = 25) String name, @RequestParam(required = false) Long parentId) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        productCategoryService.updateProductCategory(productCategory, parentId);
        return ResponseEntity.noContent().build();
    }


}
