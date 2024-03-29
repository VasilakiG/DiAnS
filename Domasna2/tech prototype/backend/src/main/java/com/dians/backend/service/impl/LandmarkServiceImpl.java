package com.dians.backend.service.impl;

import com.dians.backend.model.Landmark;
import com.dians.backend.repository.LandmarkRepository;
import com.dians.backend.service.LandmarkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandmarkServiceImpl implements LandmarkService {

    private final LandmarkRepository landmarkRepository;

    public LandmarkServiceImpl(LandmarkRepository landmarkRepository) {
        this.landmarkRepository = landmarkRepository;
    }

    @Override
    public List<Landmark> findAll() {
        return this.landmarkRepository.findAll();
    }

    @Override
    public Optional<Landmark> findById(Long id) {
        return this.landmarkRepository.findById(id);
    }
}
