package com.leandro.product_management_api.infra.persistence;

import com.leandro.product_management_api.core.domain.entity.User;
import com.leandro.product_management_api.core.domain.repository.UserRepository;
import com.leandro.product_management_api.infra.entity.UserEntity;
import com.leandro.product_management_api.infra.repository.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryImpl(JpaUserRepository jpaUserRepository){
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaUserRepository.existsById(id);
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        UserEntity saved = jpaUserRepository.save(entity);
        return toDomain(saved);
    }


    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id)
                .map(this::toDomain);
    }

    private User toDomain(UserEntity entity){
        return new User(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getRole());
    }

    private UserEntity toEntity(User user){
        if (user.getId() == null){
            return new UserEntity( user.getEmail(), user.getPassword(), user.getRole());
        }
        return new UserEntity(user.getId(), user.getEmail(), user.getPassword(), user.getRole());
    }
}
