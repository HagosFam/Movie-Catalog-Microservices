package com.microservice.moviecatelogservice.web;

import com.microservice.moviecatelogservice.domain.CatalogItem;
import com.microservice.moviecatelogservice.domain.Movie;
import com.microservice.moviecatelogservice.domain.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogController {

    // this the inital work
    @RequestMapping("/catalog/{id}")
    public List<CatalogItem> getCatalog(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
    //  Movie movie=  restTemplate.getForObject("http://localhost:8082/movies/foo", Movie.class);



        List<Rating> ratings = Arrays.asList(
                new Rating("1", 4),
                new Rating("2", 5)
        );

     return    ratings.stream()
                .map(rating -> {
                Movie movie=    restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                   return new CatalogItem(movie.getName(),"The love story", rating.getRating());
                })
                .collect(Collectors.toList());
    }


}
