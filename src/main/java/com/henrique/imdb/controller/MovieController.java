package com.henrique.imdb.controller;

import com.henrique.imdb.model.Movie;
import com.henrique.imdb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/movie")
    public ResponseEntity<Movie> createTutorial(@RequestBody Movie movie) {
        try {
            Movie _movie = movieRepository
                    .save(new Movie(movie.getTitle(), movie.getDescription(), movie.getPublishingDate()));
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
