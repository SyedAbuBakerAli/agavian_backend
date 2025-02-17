package com.syed.Agavian.controller;

import com.syed.Agavian.entity.MovieEntity;
import com.syed.Agavian.entity.ReviewEntity;
import com.syed.Agavian.service.MovieService;
import com.syed.Agavian.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    public MovieService movieService;

    @Autowired
    public ReviewService reviewService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public ResponseEntity<MovieEntity> addMovie(@RequestBody MovieEntity movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }


    @PostMapping("/{movieId}/reviews")
    public ResponseEntity<ReviewEntity> addReview(@PathVariable Long movieId, @RequestBody ReviewEntity review) {
        return ResponseEntity.ok(reviewService.addReview(movieId, review));
    }


    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<ReviewEntity> updateReview(@PathVariable Long reviewId, @RequestBody ReviewEntity review) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, review));
    }
}
