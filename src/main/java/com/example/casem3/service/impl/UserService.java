package com.example.casem3.service.impl;

import com.example.casem3.dao.IUserDAO;
import com.example.casem3.dao.impl.UserDAO;
import com.example.casem3.model.User;
import com.example.casem3.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    @Override
    public boolean authenticate(String username, String password) {
        return userDAO.authenticate(username, password);
    }

    @Override
    public String getRole(String username) {
        return userDAO.getRole(username);
    }

    @Override
    public List<String> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(String userName, String password) {
        userDAO.addUser(userName, password);
    }
}
