package com.example.saniashop.dto.product;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID id;

    @NotBlank(message = "Product name is mandatory")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Price is mandatory")
    @Max(value = 999999, message = "Price cannot exceed 999999")
    @Positive(message = "Price must be a positive number")
    private Integer price;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 500)
    private String description;

    @NotBlank(message = "Category is mandatory")
    private ProductCategoryDto productCategory;
}
