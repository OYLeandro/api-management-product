package com.leandro.product_management_api.core.domain.role;


public enum UserRole {
    ADMIN("admin"),

    USER("user");

    private String role;

     UserRole(String role){
         this.role = role;
     }

     public String getRole(){
         return role;
     }
}
