package com.leandro.product_management_api.infra.repository;

import com.leandro.product_management_api.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
