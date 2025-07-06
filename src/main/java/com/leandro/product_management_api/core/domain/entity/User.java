package com.leandro.product_management_api.core.domain.entity;

import com.leandro.product_management_api.core.domain.role.UserRole;

public class User {
    private Long id;
    private String email;
    private String password;
    private UserRole role;

    public User(String email, String password, UserRole role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void updateEmail(String email){
        this.email = email;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public void updateRole(UserRole role){
        this.role = role;
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
