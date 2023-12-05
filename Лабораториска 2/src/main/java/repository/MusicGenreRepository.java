package repository;

import model.MusicGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long> { }
