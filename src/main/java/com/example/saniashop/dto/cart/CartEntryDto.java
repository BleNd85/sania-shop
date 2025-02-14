package com.example.saniashop.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CartEntryDto {

    @NotNull(message = "Product id is mandatory")
    private UUID productId;

    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;
}
