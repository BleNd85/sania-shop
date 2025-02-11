package com.example.saniashop.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_reviews")
public class ProductReviewEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @NaturalId
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @NaturalId
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at", nullable = false)
    private Timestamp created;

    //todo List<ReviewImageEntity> urls

}
