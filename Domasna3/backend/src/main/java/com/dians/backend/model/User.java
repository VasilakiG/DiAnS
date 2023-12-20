package com.dians.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "[users]")
public class User implements AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;

    public User(){}

    public User(String username, String password, String name, String surname){
        this.id = (long) (Math.random()*1000);
        this.username=username;
        this.password=password;
        this.name=name;
        this.surname=surname;
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getPassword(){
        return this.password;
    }
}
