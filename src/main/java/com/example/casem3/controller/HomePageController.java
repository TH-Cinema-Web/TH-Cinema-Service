package com.example.casem3.controller;

import com.example.casem3.model.Movie;
import com.example.casem3.service.IMovieService;
import com.example.casem3.service.impl.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home-page")
public class HomePageController extends HttpServlet {
    private IMovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = movieService.getAllMovies();
        System.out.println("Movies retrieved: " + movies.size());
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
        req.setAttribute("movies", movies);
        RequestDispatcher dispatcher = req.getRequestDispatcher("home-page.jsp");
        dispatcher.forward(req, resp);
    }
}
