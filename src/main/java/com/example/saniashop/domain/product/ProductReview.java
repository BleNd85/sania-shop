package com.example.saniashop.domain.product;

import com.example.saniashop.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductReview {

    private UUID id;

    private User user;

    private Product product;

    private Integer rating;

    private String comment;

    private Timestamp created;
}
