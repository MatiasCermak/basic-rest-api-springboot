package com.mcrmk.moviesApi.service.impl;

import com.mcrmk.moviesApi.exception.ResourceNotFoundException;
import com.mcrmk.moviesApi.model.Movie;
import com.mcrmk.moviesApi.repository.MovieRepository;
import com.mcrmk.moviesApi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @Override
    public Movie retrieve(long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", id));
    }

    @Override
    public Movie update(Movie movie, long id) {
        Movie updatedMovie = this.retrieve(id);
        updatedMovie.setName(movie.getName());
        updatedMovie.setRating(movie.getRating());
        movieRepository.save(updatedMovie);
        return updatedMovie;
    }

    @Override
    public Movie delete(long id) {
        Movie deletedMovie = this.retrieve(id);
        movieRepository.deleteById(id);
        return deletedMovie;
    }


}
