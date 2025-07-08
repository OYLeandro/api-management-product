package com.leandro.product_management_api.infra.implementation;

import com.leandro.product_management_api.application.interfaces.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordHashedImpl implements PasswordHasher {


    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }
}
