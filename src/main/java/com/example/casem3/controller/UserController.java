package com.example.casem3.controller;

import com.example.casem3.service.IUserService;
import com.example.casem3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/user/add.jsp");
                rd.forward(req, resp);
                break;
            default:

        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        try {
            userService.addUser(userName, password);
            req.setAttribute("successMessage", "Registration successful! Please log in.");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Username already exists, please try a different one.");
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user/add.jsp");
            try {
                rd.forward(req, resp);
            } catch (ServletException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                addUser(req, resp);
                break;
        }
    }
}
