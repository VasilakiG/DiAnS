package com.dians.backend.service.impl;

import com.dians.backend.model.AdminUser;
import com.dians.backend.repository.AdminUserRepository;
import com.dians.backend.service.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository adminUserRepository;

    public AdminUserServiceImpl(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    private boolean credentialsInvalid(String adminUsername, String adminPassword){
        return adminUsername==null || adminUsername.isEmpty() || adminPassword==null || adminPassword.isEmpty();
    }

    @Override
    public AdminUser login(String adminUsername, String adminPassword) {
        if(credentialsInvalid(adminUsername, adminPassword)){
            throw new RuntimeException();
        }

        return adminUserRepository.findByAdminUsernameAndAdminPassword(adminUsername,adminPassword);
    }

    @Override
    public AdminUser register(String adminUsername, String adminPassword, String repeatPassword, String adminName, String adminSurname) {
        if(credentialsInvalid(adminUsername, adminPassword)){
            throw new RuntimeException();
        }

        if(!adminPassword.equals(repeatPassword)){
            throw new RuntimeException();
        }

        AdminUser adminUser = new AdminUser(adminUsername, adminPassword, adminName, adminSurname);
        return adminUserRepository.save(adminUser);
    }

    @Override
    public List<AdminUser> findAll() {
        return adminUserRepository.findAll();
    }
}
