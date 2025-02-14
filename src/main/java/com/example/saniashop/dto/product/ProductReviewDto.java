package com.example.saniashop.dto.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductReviewDto {

    private UUID id;

    private String userName;

    private UUID productId;

    @NotBlank(message = "Rating is mandatory")
    private Integer rating;

    @NotBlank(message = "Comment is mandatory")
    private String comment;

    private Timestamp reviewDate;
}
