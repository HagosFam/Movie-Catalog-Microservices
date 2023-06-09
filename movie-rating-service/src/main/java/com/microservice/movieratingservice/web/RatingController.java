package com.microservice.movieratingservice.web;

import com.microservice.movieratingservice.domain.Rating;
import com.microservice.movieratingservice.domain.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RatingController {

    @RequestMapping("/ratingdata/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getRatings(@PathVariable("userId") String movieId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setRatingList(ratingList);
        return userRatings;
    }

}
