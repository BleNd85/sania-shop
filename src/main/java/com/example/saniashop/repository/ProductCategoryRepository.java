package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends NaturalIdRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByParentCategoryIsNull();

    List<CategoryEntity> findByName(String name);

    List<CategoryEntity> findByParentCategory(CategoryEntity parentCategory);

}
