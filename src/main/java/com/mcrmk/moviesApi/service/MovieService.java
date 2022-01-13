package com.mcrmk.moviesApi.service;

import com.mcrmk.moviesApi.model.Movie;

import java.util.List;

public interface MovieService {
    Movie create(Movie movie);
    List<Movie> list();
    Movie retrieve(long id);
    Movie update(Movie movie, long id);
    Movie delete(long id);
}
