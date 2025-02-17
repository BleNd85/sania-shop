package com.example.saniashop.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto {

    private String name;

    private ProductCategoryDto parentCategory;

    private List<ProductCategoryDto> subCategories;
}
