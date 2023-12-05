package controller;

import model.MusicGenre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MusicGenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Validated
@CrossOrigin(origins="*")
public class MusicGenreController {

    private final MusicGenreService musicGenreService;

    public MusicGenreController(MusicGenreService musicGenreService) {
        this.musicGenreService = musicGenreService;
    }

    @GetMapping(value = "/id")
    ResponseEntity<Optional<MusicGenre>> responseId( Long id ) {
        Optional<MusicGenre> songId = musicGenreService.findMusicGenreById(id);
        return new ResponseEntity<>(songId, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    ResponseEntity<List<MusicGenre>> responseAll(){
        List<MusicGenre> allSongs = musicGenreService.findAllMusicGenres();
        return new ResponseEntity<>(allSongs, HttpStatus.OK);
    }
}
