package com.example.casem3.controller;

import com.example.casem3.model.Movie;
import com.example.casem3.model.Ticket;
import com.example.casem3.service.IMovieService;
import com.example.casem3.service.ITicketService;
import com.example.casem3.service.impl.MovieService;
import com.example.casem3.service.impl.TicketService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/book-ticket")
public class BookTicketsController extends HttpServlet {
    private ITicketService ticketService = new TicketService();
    private IMovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = movieService.getAllMovies();
        req.setAttribute("movies", movies);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book-tickets.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movie"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        LocalTime time = LocalTime.parse(req.getParameter("time"));
        int seats = Integer.parseInt(req.getParameter("seats"));

        Movie movie = movieService.getMovieById(movieId);
        Ticket ticket = new Ticket(movie, date, time, seats);
        ticketService.bookTickets(ticket);

        RequestDispatcher dispatcher = req.getRequestDispatcher("ticket-confirmation.jsp");
        dispatcher.forward(req, resp);
    }
}
