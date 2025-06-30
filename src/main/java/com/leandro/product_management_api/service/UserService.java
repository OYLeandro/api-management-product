package com.leandro.product_management_api.service;

import com.leandro.product_management_api.domain.entity.UserEntity;
import com.leandro.product_management_api.dtos.requestdtos.AuthRequestDTO;
import com.leandro.product_management_api.dtos.requestdtos.UserRequestDto;
import com.leandro.product_management_api.dtos.responsedtos.AuthResponseDTO;
import com.leandro.product_management_api.dtos.responsedtos.UserResponseDto;
import com.leandro.product_management_api.dtos.updatedto.UserUpdateDTO;
import com.leandro.product_management_api.mapper.UserMapper;
import com.leandro.product_management_api.repository.UserRepository;
import com.leandro.product_management_api.role.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponseDto registerUser(UserRequestDto dto){
        String email = dto.email().trim();
        String password = dto.password().trim();

        if(repository.existsByEmail(email) ){
          throw new RuntimeException("Email already registered");
        }
        String passwordEncrypt = passwordEncoder.encode(password);

        UserEntity user = mapper.toEntity(dto);
        user.setPassword(passwordEncrypt);
        user.setEmail(email);

        UserEntity saved = repository.save(user);
        return mapper.toDto(saved);
    }

    public AuthResponseDTO login(AuthRequestDTO dto){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email().trim(), dto.password().trim()) );

        var user = (UserEntity) authentication.getPrincipal();
        var token = tokenService.generateToken(user);
        return new AuthResponseDTO(token);
    }

    public UserResponseDto updateUser(Long id, UserUpdateDTO dto){
       UserEntity user = repository.findById(id)
               .orElseThrow(() -> new RuntimeException("User not found with ID "+ id));

       String email = dto.email() != null ? dto.email().trim() : null;
       String password = dto.password() != null ? dto.password().trim() : null;
       UserRole role = dto.role();

       if (email != null){
           if (email.isBlank()){
               throw new IllegalArgumentException("Email cannot be empty");
           }
           if (repository.existsByEmail(email) && !user.getEmail().equalsIgnoreCase(email) ){
               throw new RuntimeException("Email already registered by another user");
           }
           user.setEmail(email);
       }

       if (password != null){
           if(password.isBlank()){
               throw new IllegalArgumentException("Password cannot be empty");
           }
           String newPasswordEncrypt = passwordEncoder.encode(password);
           user.setPassword(newPasswordEncrypt);
       }

       if (role != null){
           user.setRole(role);
       }
       repository.save(user);
        return mapper.toDto(user);
    }

    public void deleteUserById(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("User not found with id "+id);
        }
        repository.deleteById(id);
    }
}
