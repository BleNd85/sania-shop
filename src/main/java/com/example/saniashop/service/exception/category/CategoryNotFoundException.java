package com.example.saniashop.service.exception.category;

public class CategoryNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Category with id %s not found";

    public CategoryNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
