package com.dians.backend.service;

import com.dians.backend.model.Landmark;

import java.util.List;
import java.util.Optional;

public interface LandmarkService {
    List<Landmark> findAll();
    Optional<Landmark> findById(Long id);
    void deleteById(Long id);
    Optional<Landmark> save(String historic, String tourism, String way);
    Optional<Landmark> edit(Long id, String historic, String tourism, String way);
    List<Landmark> searchByHistoric(String historic);
    List<Landmark> searchByTourism(String tourism);
}
