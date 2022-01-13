package com.mcrmk.moviesApi.repository;

import com.mcrmk.moviesApi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long > {
}
