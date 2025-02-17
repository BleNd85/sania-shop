package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CartEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends NaturalIdRepository<CartEntity, UUID> {

    Optional<CartEntity> findByUserId(UUID userId);
}
