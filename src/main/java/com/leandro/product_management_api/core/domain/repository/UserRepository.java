package com.leandro.product_management_api.core.domain.repository;

import com.leandro.product_management_api.core.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User save(User user);
    void delete(User user);
    void deleteById(Long id);
    Optional<User> findById(Long id);
}
