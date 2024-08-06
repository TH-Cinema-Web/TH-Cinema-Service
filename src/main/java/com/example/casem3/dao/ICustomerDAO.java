package com.example.casem3.dao;

import com.example.casem3.model.Customer;
import com.example.casem3.model.Employee;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> getAllCustomers();
    List<Customer> getCustomerByName(String fullName);
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(String phoneNumber);
    boolean editCustomer(Customer customer);
}
