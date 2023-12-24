package com.dians.backend.service.impl;

import com.dians.backend.model.Landmark;
import com.dians.backend.model.Review;
import com.dians.backend.repository.LandmarkRepository;
import com.dians.backend.repository.ReviewRepository;
import com.dians.backend.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final LandmarkRepository landmarkRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, LandmarkRepository landmarkRepository) {
        this.reviewRepository = reviewRepository;
        this.landmarkRepository = landmarkRepository;
    }

    @Override
    public Review addReviewToLandmark(Long landmarkId, Integer score, String description) {
        Landmark landmark = landmarkRepository.findById(landmarkId).get();
        Review review = new Review(score, description, landmark);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
