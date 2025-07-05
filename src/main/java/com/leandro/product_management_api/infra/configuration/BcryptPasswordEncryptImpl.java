package com.leandro.product_management_api.infra.configuration;

import com.leandro.product_management_api.application.security.PasswordEncrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncryptImpl implements PasswordEncrypt {
    private final PasswordEncoder encoder;

    public BcryptPasswordEncryptImpl(PasswordEncoder encoder){
        this.encoder = encoder;
    }

    @Override
    public String encrypt(String password) {
        return encoder.encode(password);
    }
}
