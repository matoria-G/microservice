package com.matoria.moviecatalog.controller;

import com.matoria.moviecatalog.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<Movie> getMoviesCatalog(@PathVariable("userId") String userId) {
        List<Movie> movies = Arrays.asList(
                new Movie("123", "", 0),
                new Movie("124", "", 0)
        );
        return movies.stream().map(movie -> {
                    Movie movieinfo = restTemplate.getForObject("http://localhost:8086/movieInfo/" + movie.getId(), Movie.class);
                    Movie movierating = restTemplate.getForObject("http://localhost:8088/rating/" + movie.getId(), Movie.class);
                    return new Movie(movie.getId(), movieinfo.getDesc(), movierating.getRating());
                })
                .collect(Collectors.toList());

    }
}
