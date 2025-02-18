package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.entity.ProductEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends NaturalIdRepository<ProductEntity, UUID> {

    List<ProductEntity> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String keyword1, String keyword2);

    List<ProductEntity> findByCategoryIdAndNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(Long categoryId, String name, String description);

    List<ProductEntity> findByCategoryId(Long categoryId);

    List<ProductEntity> findByCategoryAndName(CategoryEntity category, String name);

    List<ProductEntity> findByDescription(String description);

    List<ProductEntity> findByPriceIsBetween(Integer min, Integer max);

}
