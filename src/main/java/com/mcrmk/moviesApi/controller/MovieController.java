package com.mcrmk.moviesApi.controller;

import com.mcrmk.moviesApi.model.Movie;
import com.mcrmk.moviesApi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        Movie returnMovie = movieService.create(movie);
        return new ResponseEntity<>(returnMovie, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.list(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id){
        return new ResponseEntity<>(movieService.retrieve(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable("id") long id){
        return new ResponseEntity<>(movieService.update(movie, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id){
        return new ResponseEntity<>(movieService.delete(id), HttpStatus.OK);
    }
}
