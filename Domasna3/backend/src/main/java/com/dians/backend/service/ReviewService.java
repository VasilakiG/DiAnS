package com.dians.backend.service;

import com.dians.backend.model.Review;

import java.util.List;

public interface ReviewService {

    Review addReviewToLandmark(Long landmarkId, Integer score, String description);

    List<Review> findAll();
}
