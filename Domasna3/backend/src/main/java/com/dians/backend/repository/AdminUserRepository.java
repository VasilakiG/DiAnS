package com.dians.backend.repository;

import com.dians.backend.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    AdminUser findByAdminUsernameAndAdminPassword(String adminUsername, String adminPassword);
}
