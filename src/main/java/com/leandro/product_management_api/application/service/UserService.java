package com.leandro.product_management_api.application.service;

import com.leandro.product_management_api.application.dtos.UserRequestDTO;
import com.leandro.product_management_api.application.security.PasswordEncrypt;
import com.leandro.product_management_api.core.domain.entity.User;
import com.leandro.product_management_api.core.domain.exception.*;
import com.leandro.product_management_api.core.domain.repository.UserRepository;
import com.leandro.product_management_api.core.domain.role.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncrypt passwordEncrypt;

    public UserService(UserRepository repository, PasswordEncrypt passwordEncrypt){
        this.repository = repository;
        this.passwordEncrypt = passwordEncrypt;
    }

    public User register(UserRequestDTO dto){
        validateUserRequest(dto);
        String email = dto.email().trim();
        String password = dto.password().trim();
        if(repository.existsByEmail(email)){throw new EmailAlreadyRegisteredException();}

        String passwordEncrypted = passwordEncrypt.encrypt(password);

        User newUser = new User(email, passwordEncrypted, dto.role());
        return repository.save(newUser);
    }

    public void updateUser(Long id, UserRequestDTO dto){
        User newUser = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: "+ id) );

        String email = dto.email() != null ? dto.email().trim() : null;
        String password = dto.password() != null ? dto.password().trim() : null;
        UserRole role = dto.role();

        if (email != null){
            if (email.isBlank()){
            throw new EmailInvalidException("Email cannot be empty");
            }
            if (!newUser.getEmail().equalsIgnoreCase(email)){
                if( repository.existsByEmail(email)) {
                throw new EmailAlreadyRegisteredException("Email already registered by another user");
                }
            newUser.updateEmail(email);
            }
        }

        if (password != null){
            if (password.isBlank()){
                throw new PasswordInvalidException("Password cannot be empty");
            }
            String newPass = passwordEncrypt.encrypt(password);
            newUser.updatePassword(newPass);
        }

        if (role != null){
            newUser.updateRole(role);
        }
        repository.save(newUser);
    }

    public void deleteById(Long id){
        if (!repository.existsById(id)){throw new UserNotFoundException("User not found with id "+id);}
        repository.deleteById(id);
    }

    private void validateUserRequest(UserRequestDTO requestDTO){
        String email = requestDTO.email();
        String password = requestDTO.password();
        if (email == null || email.isBlank()){throw new EmailInvalidException("Email required"); }
        if (password == null || password.isBlank()){throw new PasswordInvalidException("Password required"); }
        if (requestDTO.role() == null){throw new RoleInvalidException("Role required");}
    }
}
