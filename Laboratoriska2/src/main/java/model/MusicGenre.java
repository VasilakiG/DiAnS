package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "music_genre")
@NoArgsConstructor
@AllArgsConstructor
public class MusicGenre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Long length_of_song;

    @NotNull
    @Positive
    private Long year_of_release;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLength_of_song(Long length_of_song) {
        this.length_of_song = length_of_song;
    }

    public void setYear_of_release(Long year_of_release) {
        this.year_of_release = year_of_release;
    }
}
