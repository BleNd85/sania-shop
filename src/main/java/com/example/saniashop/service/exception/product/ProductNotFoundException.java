package com.example.saniashop.service.exception.product;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    private static final String PRODUCT_NOT_FOUND = "Product with id %s not found";

    public ProductNotFoundException(UUID id) {
        super(String.format(PRODUCT_NOT_FOUND, id));
    }
}
