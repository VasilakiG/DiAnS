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

    @Override
    public void deleteById(Long id) {
        landmarkRepository.deleteById(id);
    }

    @Override
    public Optional<Landmark> save(String historic, String tourism, String way) {
        return Optional.of(landmarkRepository.save(new Landmark(historic, tourism, way)));
    }

    @Override
    public Optional<Landmark> edit(Long id, String historic, String tourism, String way) {
        Landmark landmark = landmarkRepository.findById(id).orElseThrow();
        landmark.setHistoric(historic);
        landmark.setTourism(tourism);
        landmark.setWay(way);
        landmarkRepository.save(landmark);
        return Optional.of(landmark);
    }

    @Override
    public List<Landmark> searchByHistoric(String historic) {
        return landmarkRepository.searchByHistoric(historic);
    }

    @Override
    public List<Landmark> searchByTourism(String tourism) {
        return landmarkRepository.searchByTourism(tourism);
    }
}
