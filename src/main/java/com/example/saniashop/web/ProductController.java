package com.example.saniashop.web;

import com.example.saniashop.dto.product.ProductDto;
import com.example.saniashop.service.ProductService;
import com.example.saniashop.service.mapper.ProductServiceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductServiceMapper productServiceMapper;

    public ProductController(ProductService productService, ProductServiceMapper productServiceMapper) {
        this.productService = productService;
        this.productServiceMapper = productServiceMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok(productServiceMapper.toProductDto(productService.getAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productServiceMapper.toProductDto(productService.getProductById(id)));
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ProductDto>> findProductsByKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(productServiceMapper.toProductDto(productService.getProductsByNameOrDescription(keyword)));
    }
}
