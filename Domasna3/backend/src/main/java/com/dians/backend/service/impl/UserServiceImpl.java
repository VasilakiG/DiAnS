package com.dians.backend.service.impl;

import com.dians.backend.model.User;
import com.dians.backend.repository.UserRepository;
import com.dians.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean credentialsInvalid(String username, String password){
        return username==null || username.isEmpty() || password==null || password.isEmpty();
    }

    @Override
    public User login(String username, String password) {
        if(credentialsInvalid(username,password)){
            throw new RuntimeException();
        }

        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(credentialsInvalid(username, password)){
            throw new RuntimeException();
        }

        if(!password.equals(repeatPassword)){
            throw new RuntimeException();
        }

        User user = new User(username, password, name, surname);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
