package com.leandro.product_management_api.infra.controller;

import com.leandro.product_management_api.infra.dtos.requestdtos.AuthRequestDTO;
import com.leandro.product_management_api.infra.dtos.requestdtos.UserRequestDto;
import com.leandro.product_management_api.infra.dtos.responsedtos.AuthResponseDTO;
import com.leandro.product_management_api.infra.dtos.responsedtos.UserResponseDto;
import com.leandro.product_management_api.infra.dtos.updatedto.UserUpdateDTO;
import com.leandro.product_management_api.infra.service.UserService;
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

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRequestDto dto){
        UserResponseDto user = service.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO requestDto){
        AuthResponseDTO user = service.login(requestDto);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Long id){
        service.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody Long id, UserUpdateDTO updateDTO){
        return ResponseEntity.ok().body(service.updateUser(id, updateDTO));
    }
}
