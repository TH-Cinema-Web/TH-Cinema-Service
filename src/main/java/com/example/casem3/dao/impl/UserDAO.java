package com.example.casem3.dao.impl;

import com.example.casem3.dao.IUserDAO;
import com.example.casem3.model.User;
import com.example.casem3.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final String SELECT_ALL_USERS = "SELECT username FROM users";
    private static final String AUTHENTICATE_SQL = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String GET_ROLE_SQL = "SELECT r.role_name FROM userroles ur JOIN roles r ON ur.role_id = r.role_id WHERE ur.username = ?";
    private static final Connection connection = JDBCConnection.getConnection();

    @Override
    public boolean authenticate(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(AUTHENTICATE_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getRole(String username) {
        String roleName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_SQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                roleName = resultSet.getString("role_name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roleName;
    }

    @Override
    public List<String> getAllUsers() {
        List<String> usernames = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                usernames.add(username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usernames;
    }

    @Override
    public void addUser(String userName, String password) {
        CallableStatement callableStatement;
        ResultSet resultSet;

        try {
            String sql = "{call AddUser(?, ?)}";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, userName);
            callableStatement.setString(2, password);

            boolean hasResultSet = callableStatement.execute();
            if (hasResultSet) {
                resultSet = callableStatement.getResultSet();
                if (resultSet.next()) {
                    String accountError = resultSet.getString("AccountError");
                    if (accountError != null) {
                        System.out.println("Error: " + accountError);
                        throw new RuntimeException("Account already exists");
                    }
                }
            } else {
                System.out.println("User added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
