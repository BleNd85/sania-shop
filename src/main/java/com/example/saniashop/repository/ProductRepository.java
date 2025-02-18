package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.entity.ProductEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends NaturalIdRepository<ProductEntity, UUID> {

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCategoryId(Long categoryId);

    List<ProductEntity> findByCategoryAndName(CategoryEntity category, String name);

    List<ProductEntity> findByDescription(String description);

    List<ProductEntity> findProductEntityByPriceIsBetween(Integer min, Integer max);

}
