package com.dians.hw2.service;

import com.dians.hw2.model.Landmark;

import java.util.List;
import java.util.Optional;

public interface LandmarkService {
    List<Landmark> findAll();
    Optional<Landmark> findById(Long id);
}
