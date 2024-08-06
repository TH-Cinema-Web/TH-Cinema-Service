package com.example.casem3.service;

import com.example.casem3.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    List<Customer> getCustomerByName(String fullName);
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(String phoneNumber);
    boolean editCustomer(Customer customer);
}
