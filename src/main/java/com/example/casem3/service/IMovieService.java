package com.example.casem3.service;

import com.example.casem3.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(int movieId);
}
