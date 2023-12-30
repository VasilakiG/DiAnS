package com.dians.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="[landmarks]")
@NoArgsConstructor
@AllArgsConstructor
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long osm_id;
    private String historic;
    private String tourism;
    private String way;
    @OneToMany(mappedBy = "landmark", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;

    public Landmark(String historic, String tourism, String way){
        this.osm_id =(long) (Math.random()*1000);
        this.historic=historic;
        this.tourism=tourism;
        this.way=way;
        this.reviewList = new ArrayList<>();
    }
}
