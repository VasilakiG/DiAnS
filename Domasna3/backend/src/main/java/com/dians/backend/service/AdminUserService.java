package com.dians.backend.service;

import com.dians.backend.model.AdminUser;

import java.util.List;

public interface AdminUserService {

    AdminUser login(String adminUsername, String adminPassword);

    AdminUser register(String adminUsername, String adminPassword, String repeatPassword, String adminName, String adminSurname );

    List<AdminUser> findAll();
}
