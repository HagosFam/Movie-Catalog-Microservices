package com.microservice.movieinfoservice.web;

import com.microservice.movieinfoservice.domain.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @RequestMapping("/movies/{id}")
    public Movie getMovieInfo(@PathVariable String id) {
        return new Movie("12121", "The note book");
    }
}
