package com.example.casem3.service.impl;

import com.example.casem3.dao.IMovieDAO;

import com.example.casem3.dao.impl.MovieDAO;
import com.example.casem3.model.Movie;
import com.example.casem3.service.IMovieService;
import java.util.List;

public class MovieService implements IMovieService {
    private IMovieDAO movieDAO = new MovieDAO();

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return null;
    }
}
