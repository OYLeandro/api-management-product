package com.leandro.product_management_api.application.service;

import com.leandro.product_management_api.application.dtos.AuthRequestDTO;
import com.leandro.product_management_api.application.dtos.AuthResponseDTO;
import com.leandro.product_management_api.application.dtos.UserRequestDTO;
import com.leandro.product_management_api.application.dtos.UserResponseDTO;
import com.leandro.product_management_api.application.interfaces.PasswordEncrypt;
import com.leandro.product_management_api.application.interfaces.PasswordHasher;
import com.leandro.product_management_api.application.interfaces.TokenProvider;
import com.leandro.product_management_api.core.domain.entity.User;
import com.leandro.product_management_api.core.domain.exception.*;
import com.leandro.product_management_api.core.domain.repository.UserRepository;
import com.leandro.product_management_api.core.domain.role.UserRole;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncrypt passwordEncrypt;
    private final TokenProvider tokenProvider;
    private final PasswordHasher passwordHasher;

    public UserService(UserRepository repository, PasswordEncrypt passwordEncrypt, TokenProvider tokenProvider, PasswordHasher passwordHasher){
        this.tokenProvider = tokenProvider;
        this.passwordHasher = passwordHasher;
        this.repository = repository;
        this.passwordEncrypt = passwordEncrypt;
    }

    public UserResponseDTO register(UserRequestDTO dto){
        validateUserRequest(dto);
        String email = dto.email().trim();
        String password = dto.password().trim();
        if(repository.existsByEmail(email)){throw new EmailAlreadyRegisteredException();}

        String passwordEncrypted = passwordEncrypt.encrypt(password);

        User newUser = new User(email, passwordEncrypted, dto.role());
        repository.save(newUser);
        return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
    }

    public AuthResponseDTO login (AuthRequestDTO requestDTO){
        Optional<User> userOptional = repository.findByEmail(requestDTO.email().trim());
        if(userOptional.isEmpty()){
            throw new InvalidCredentialsException("Email or Password invalid");
        }

        User user = userOptional.get();

        if (!passwordHasher.matches(requestDTO.password(), user.getPassword())){
            throw new InvalidCredentialsException("Email or Password invalid");
        }

        String token = tokenProvider.generateToken(user);

        return new AuthResponseDTO(token);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){
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
        return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
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
