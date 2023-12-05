package com.dians.backend.service;

import com.dians.backend.model.Landmark;

import java.util.List;
import java.util.Optional;

public interface LandmarkService {
    List<Landmark> findAll();
    Optional<Landmark> findById(Long id);
}
