package com.leandro.product_management_api.application.interfaces;

public interface PasswordHasher {
    boolean matches (String password, String hashedPassword);
}
