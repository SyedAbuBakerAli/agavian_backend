package com.syed.Agavian.service;

import com.syed.Agavian.entity.MovieEntity;
import com.syed.Agavian.entity.ReviewEntity;
import com.syed.Agavian.repository.MovieRepository;
import com.syed.Agavian.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    public MovieRepository movieRepository;

    public ReviewEntity addReview(Long movieId, ReviewEntity review) {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            review.setMovie(movie.get());
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Movie not found");
        }
    }

    public ReviewEntity updateReview(Long reviewId, ReviewEntity updatedReview) {
        return reviewRepository.findById(reviewId).map(review -> {
            review.setComment(updatedReview.getComment());
            review.setRating(updatedReview.getRating());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found"));
    }
}
