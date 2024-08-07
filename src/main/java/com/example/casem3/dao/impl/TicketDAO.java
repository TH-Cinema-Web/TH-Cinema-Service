package com.example.casem3.dao.impl;

import com.example.casem3.dao.ITicketDAO;
import com.example.casem3.model.Ticket;
import com.example.casem3.utils.JDBCConnection;

import java.sql.*;

public class TicketDAO implements ITicketDAO {
    @Override
    public void bookTickets(Ticket ticket) {
        String sql = "INSERT INTO Tickets (movie_id, date, time, seats) VALUES (?, ?, ?, ?)";

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ticket.getMovie().getId());
            statement.setDate(2, java.sql.Date.valueOf(ticket.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(ticket.getTime()));
            statement.setInt(4, ticket.getSeats());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
