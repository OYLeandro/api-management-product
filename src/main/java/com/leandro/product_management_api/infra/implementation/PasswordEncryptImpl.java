package com.leandro.product_management_api.infra.implementation;

import com.leandro.product_management_api.application.interfaces.PasswordEncrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncryptImpl implements PasswordEncrypt {

    private final PasswordEncoder encoder;

    @Override
    public String encrypt(String password) {
        return encoder.encode(password);
    }
}
