package com.microservice.moviecatelogservice.web;
import com.microservice.moviecatelogservice.domain.CatalogItem;
import com.microservice.moviecatelogservice.domain.Movie;
import com.microservice.moviecatelogservice.domain.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogController {
    // then i autowire the RestTemplate i created so that i don't need to create RestTemplate everywhere
    @Autowired
    private RestTemplate template;

    // To call an api we can also use builder by including the spring-webflux depedency
    // WebClient.builder build = new WebClient.builder()
    // or add it on the entry application and autowire it here
    // webClientBuilder.build().get().uri("").retrieve.bodyToMono(Movie.class).block();
    // we can assign to a variable of type Movie and return it

    // this the inital work
    @RequestMapping("/catalog/{id}")
    public List<CatalogItem> getCatalog(@PathVariable String id) {

        // i dont need to create this RestTemplate every class i need
        // RestTemplate restTemplate = new RestTemplate();
        //  Movie movie=  restTemplate.getForObject("http://localhost:8082/movies/foo", Movie.class);

        // the following is hard coded list, but we can make a restTemplate call and get the list of ratings
    /*
    * List<Rating> ratings = Arrays.asList(
                new Rating("1", 4),
                new Rating("2", 5)
        );
    *
    * */

        // so here after we added @LoadBalanced to our rest template, we replace the localhost:8083 or other url with service name
        //  UserRatings ratings = template.getForObject("http://localhost:8083/users/" + id, UserRatings.class);, becomes
        UserRatings ratings = template.getForObject("http://movie-rating-service/users/" + id, UserRatings.class);

        return ratings.getRatingList().stream()
                .map(rating -> {
                    Movie movie = template.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "The love story", rating.getRating());
                })
                .collect(Collectors.toList());
    }


}
