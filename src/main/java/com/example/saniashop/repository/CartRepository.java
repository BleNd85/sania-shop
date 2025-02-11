package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CartEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.UUID;

public interface CartRepository extends NaturalIdRepository<CartEntity, UUID> {

}
