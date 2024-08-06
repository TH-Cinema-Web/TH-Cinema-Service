package com.example.casem3.service.impl;

import com.example.casem3.dao.ICustomerDAO;
import com.example.casem3.dao.IEmployeeDAO;
import com.example.casem3.dao.impl.CustomerDAO;
import com.example.casem3.dao.impl.EmployeeDAO;
import com.example.casem3.model.Customer;
import com.example.casem3.service.ICustomerService;

import java.util.Collections;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAO = new CustomerDAO();
    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
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