package com.leandro.product_management_api.infra.controller;

import com.leandro.product_management_api.application.dtos.AuthRequestDTO;
import com.leandro.product_management_api.application.dtos.AuthResponseDTO;
import com.leandro.product_management_api.application.dtos.UserRequestDTO;
import com.leandro.product_management_api.application.dtos.UserResponseDTO;
import com.leandro.product_management_api.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService service;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login( @Valid @RequestBody AuthRequestDTO requestDto){
        AuthResponseDTO user = service.login(requestDto);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody Long id, UserRequestDTO requestDTO){
        return ResponseEntity.ok().body(service.updateUser(id, requestDTO));
    }
}
