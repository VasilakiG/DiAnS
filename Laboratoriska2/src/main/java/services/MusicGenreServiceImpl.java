package services;

import model.MusicGenre;
import org.springframework.stereotype.Service;
import repository.MusicGenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MusicGenreServiceImpl implements MusicGenreService{

    private final MusicGenreRepository musicGenreRepository;

    public MusicGenreServiceImpl(MusicGenreRepository musicGenreRepository) {
        this.musicGenreRepository = musicGenreRepository;
    }

    @Override
    public List<MusicGenre> findAllMusicGenres() {
        return musicGenreRepository.findAll();
    }

    @Override
    public Optional<MusicGenre> findMusicGenreById(Long id) {
        return musicGenreRepository.findById(id);
    }
}
