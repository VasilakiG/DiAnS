package com.dians.backend.service;

import com.dians.backend.model.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname );

    List<User> findAll();
}
