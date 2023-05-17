package com.microservice.movieratingservice.web;

import com.microservice.movieratingservice.domain.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @RequestMapping("/ratingdata/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }
}
