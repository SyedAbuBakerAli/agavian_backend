package com.syed.Agavian.service;

import com.syed.Agavian.entity.MovieEntity;
import com.syed.Agavian.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepository movieRepository;

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieEntity addMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }
}
