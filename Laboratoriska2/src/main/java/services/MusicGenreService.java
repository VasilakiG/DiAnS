package services;

import model.MusicGenre;

import java.util.List;
import java.util.Optional;

public interface MusicGenreService {

    List<MusicGenre> findAllMusicGenres();
    Optional<MusicGenre> findMusicGenreById( Long id );
}
