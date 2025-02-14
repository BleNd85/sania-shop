package com.example.saniashop.service;


import com.example.saniashop.domain.cart.CartEntry;

import java.util.List;
import java.util.UUID;

public interface CartService {

    List<CartEntry> getCartEntriesByCartId(UUID cartId);

    List<CartEntry> getCartEntriesByUserId(UUID userId);

    void saveCartEntry(CartEntry cartEntry);

    void deleteCartEntry(UUID cartEntryId);

}
