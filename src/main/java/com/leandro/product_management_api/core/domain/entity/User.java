package com.leandro.product_management_api.core.domain.entity;

import com.leandro.product_management_api.core.domain.exception.EmailInvalidException;
import com.leandro.product_management_api.core.domain.exception.PasswordInvalidException;
import com.leandro.product_management_api.core.domain.role.UserRole;

public class User {
    private Long id;
    private String email;
    private String password;
    private UserRole role;

    public User(String email, String password, UserRole role){
        if(email == null || email.isBlank()){ throw new EmailInvalidException(email);}
        if(password == null || password.isBlank()){throw new PasswordInvalidException(password);}
        this.email = email.trim();
        this.password = password.trim();
        this.role = role;
    }

    public void updateEmail(String email){
        if (email == null || email.isBlank()){throw new EmailInvalidException("Email invalid "+ email);}
        this.email = email.trim();
    }

    public void updatePassword(String password){
        if (password == null || password.isBlank()){throw new PasswordInvalidException("Password invalid "+ password);}
        this.password = password.trim();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole(){
        return role;
    }
}
