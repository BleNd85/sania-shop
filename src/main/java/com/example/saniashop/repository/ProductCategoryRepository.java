package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.CategoryEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends NaturalIdRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByParentCategoryIsNull();

    List<CategoryEntity> findByName(String name);

    List<CategoryEntity> findBySlug(String slug);

    @Query(value = "WITH RECURSIVE category_path AS (" +
            "SELECT id, slug, name, parent_id FROM products_categories WHERE id = :categoryId " +
            "UNION ALL " +
            "SELECT c.id, c.slug, c.name, c.parent_id FROM products_categories c " +
            "JOIN category_path cp ON cp.parent_id = c.id) " +
            "SELECT * FROM category_path", nativeQuery = true)
    List<CategoryEntity> findCategoryPath(@Param("categoryId") Long categoryId);

}
