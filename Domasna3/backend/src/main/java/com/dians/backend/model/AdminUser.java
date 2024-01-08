package com.dians.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "[adminUsers]")
public class AdminUser implements AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminUsername;
    private String adminPassword;
    private String adminName;
    private String adminSurname;

    public AdminUser(){}

    public AdminUser(String adminUsername, String adminPassword, String adminName, String adminSurname){
        this.adminUsername=adminUsername;
        this.adminPassword=adminPassword;
        this.adminName=adminName;
        this.adminSurname=adminSurname;
    }

    @Override
    public String getUsername() {
        return this.adminUsername;
    }

    @Override
    public String getPassword() {
        return this.adminPassword;
    }
}
