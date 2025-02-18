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

    private Long id;

    private String slug;

    private String name;

    private List<ProductCategoryDto> subCategories;
}
