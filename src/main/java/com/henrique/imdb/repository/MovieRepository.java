package com.henrique.imdb.repository;

import com.henrique.imdb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findByTitleContaining(String title);

    List<Movie> findByDescriptionContaining(String description);

}
