package com.example.casem3.dao.impl;

import com.example.casem3.dao.IMovieDAO;
import com.example.casem3.model.Movie;
import com.example.casem3.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements IMovieDAO {

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movies";

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setImageUrl(resultSet.getString("image_url"));
                movie.setTrailerUrl(resultSet.getString("trailer_url"));
                movie.setDescription(resultSet.getString("description"));
                movies.add(movie);
            }
            System.out.println("Number of movies found: " + movies.size()); // Thêm dòng này để kiểm tra số lượng phim tìm thấy
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
