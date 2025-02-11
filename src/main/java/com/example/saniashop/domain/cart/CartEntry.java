package com.example.saniashop.domain.cart;

import com.example.saniashop.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CartEntry {

    private UUID id;

    private Cart cart;

    private Product product;

    private Integer quantity;

}
