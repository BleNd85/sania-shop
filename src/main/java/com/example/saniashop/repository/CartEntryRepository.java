package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CartEntryEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.List;
import java.util.UUID;

public interface CartEntryRepository extends NaturalIdRepository<CartEntryEntity, UUID> {
    List<CartEntryEntity> findByCartId(UUID cartId);
}
