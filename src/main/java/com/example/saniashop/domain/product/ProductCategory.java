package com.example.saniashop.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductCategory {
    private Long id;

    private String name;

    private ProductCategory parentCategory;

    private List<ProductCategory> subCategories;

}
