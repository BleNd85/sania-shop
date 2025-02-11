package com.example.saniashop.repository;

import com.example.saniashop.repository.entity.UserEntity;
import com.example.saniashop.repository.naturalRepository.NaturalIdRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends NaturalIdRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
