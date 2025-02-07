package com.example.saniashop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "carts")
public class CartEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @OneToOne(mappedBy = "cart")
    private UserEntity user;
}
