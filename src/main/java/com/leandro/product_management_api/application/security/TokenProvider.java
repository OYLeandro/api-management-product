package com.leandro.product_management_api.application.security;

import com.leandro.product_management_api.core.domain.entity.User;

public interface TokenProvider {
    String generateToken(User user);
    String validateToken(String token);
    String getUsernameFromToken(String token);
}
