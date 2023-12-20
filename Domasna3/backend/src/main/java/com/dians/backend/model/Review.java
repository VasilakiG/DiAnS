package com.dians.hw3.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "[reviews]")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer score;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landmark_id")
    private Landmark landmark;

    public Review(){}

    public Review(Integer score, String description, Landmark landmark){
        this.id=(long) (Math.random()*1000);
        this.score=score;
        this.description=description;
        this.landmark = landmark;
    }
}
