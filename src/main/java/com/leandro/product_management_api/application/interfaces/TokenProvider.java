package com.leandro.product_management_api.application.interfaces;

import com.leandro.product_management_api.core.domain.entity.User;

public interface TokenProvider {
    String generateToken(User user);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
}
