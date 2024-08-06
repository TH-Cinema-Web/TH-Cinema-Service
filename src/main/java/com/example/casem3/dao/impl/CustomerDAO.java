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
    private final String SELECT_ALL_CUSTOMER ="SELECT * FROM customer";
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
        return Collections.emptyList();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String phoneNumber) {
        return false;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return false;
    }
}
