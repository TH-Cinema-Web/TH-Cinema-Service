package com.example.casem3.dao.impl;

import com.example.casem3.dao.ICustomerDAO;
import com.example.casem3.model.Customer;
import com.example.casem3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private final String SELECT_ALL_CUSTOMER ="SELECT * FROM customers";
    private final String INSERT_CUSTOMER_SQL ="INSERT INTO customers (phone_number,full_name,email,username) VALUES (?,?,?,?)";
    private final String UPDATE_CUSTOMER_SQL = "UPDATE customers SET full_name = ?, email = ?, username = ? WHERE phone_number = ?";
    private final String DELETE_CUSTOMER_SQL = "DELETE FROM customers WHERE phone_number = ?";
    private final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customers WHERE full_name LIKE ?";
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String phoneNumber = resultSet.getString("phone_number");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                customers.add(new Customer(phoneNumber, fullName, email, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error querying the customers", e);
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByName(String fullName) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME)) {

            preparedStatement.setString(1, "%" + fullName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String phoneNumber = resultSet.getString("phone_number");
                String name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                customers.add(new Customer(phoneNumber, name, email, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error searching for customers", e);
        }
        return customers;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setString(1, customer.getPhoneNumber());
            preparedStatement.setString(2, customer.getFullName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getUserName());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding the customer", e);
        }
    }

    @Override
    public boolean deleteCustomer(String phoneNumber) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {

            preparedStatement.setString(1, phoneNumber);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting the customer", e);
        }
    }

    @Override
    public boolean editCustomer(Customer customer) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {

            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getUserName());
            preparedStatement.setString(4, customer.getPhoneNumber());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating the customer", e);
        }
    }
}
