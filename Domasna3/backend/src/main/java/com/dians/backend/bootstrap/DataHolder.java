package com.dians.backend.bootstrap;

import com.dians.backend.model.AdminUser;
import com.dians.backend.model.User;
import com.dians.backend.repository.AdminUserRepository;
import com.dians.backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<User> users = new ArrayList<>();
    public static List<AdminUser> adminUsers = new ArrayList<>();

    private final UserRepository userRepository;
    private final AdminUserRepository adminUserRepository;

    public DataHolder(UserRepository userRepository, AdminUserRepository adminUserRepository) {
        this.userRepository = userRepository;
        this.adminUserRepository = adminUserRepository;
    }

    @PostConstruct
    public void init(){
        if(userRepository.count()==0){
            users.add(new User("user1","pass1","UserName1","UserSurname1"));

            userRepository.saveAll(users);
        }

        if(adminUserRepository.count()==0){
            adminUsers.add(new AdminUser("Admin1", "ad", "AdminName1", "AdminSurname1"));

            adminUserRepository.saveAll(adminUsers);
        }
    }
}
