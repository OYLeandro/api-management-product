package com.leandro.product_management_api.infra.persistence;

import com.leandro.product_management_api.core.domain.entity.User;
import com.leandro.product_management_api.core.domain.repository.UserRepository;
import com.leandro.product_management_api.infra.entity.UserEntity;
import com.leandro.product_management_api.infra.repository.JpaUserRepository;

import java.util.Optional;

public class JpaUserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryImpl(JpaUserRepository jpaUserRepository ){
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return ;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsById(Long Id) {
        return false;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    private User toDomain(UserEntity entity){
        return new User(entity.getEmail(), entity.getPassword(), entity.getRole());
    }

    private UserEntity toEntity(User user){
        return new UserEntity(user.getEmail(), user.getPassword(), user.getRole());
    }
}
