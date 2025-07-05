package com.leandro.product_management_api.application.service;

import com.leandro.product_management_api.application.dtos.UserRequestDTO;
import com.leandro.product_management_api.application.security.PasswordEncrypt;
import com.leandro.product_management_api.core.domain.entity.User;
import com.leandro.product_management_api.core.domain.exception.EmailAlreadyRegisteredException;
import com.leandro.product_management_api.core.domain.exception.EmailInvalidException;
import com.leandro.product_management_api.core.domain.exception.PasswordInvalidException;
import com.leandro.product_management_api.core.domain.exception.RoleInvalidException;
import com.leandro.product_management_api.core.domain.repository.UserRepository;
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
        String email = dto.email();
        String password = dto.password();

        if (email == null || email.isBlank()){throw new EmailInvalidException("Email required"); }
        if (password == null || password.isBlank()){throw new PasswordInvalidException("Password required"); }
        if (dto.role() == null){throw new RoleInvalidException("Role required");}
        if(repository.existsByEmail(email.trim())){throw new EmailAlreadyRegisteredException();}

        String passwordEncrypted = passwordEncrypt.encrypt(password.trim());

        User newUser = new User(email, passwordEncrypted, dto.role());
        return repository.save(newUser);
    }


}
