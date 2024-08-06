package com.example.casem3.controller;

import com.example.casem3.model.Customer;
import com.example.casem3.model.Employee;
import com.example.casem3.service.ICustomerService;
import com.example.casem3.service.IEmployeeService;
import com.example.casem3.service.impl.CustomerService;
import com.example.casem3.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null || (!"ROLE_ADMIN".equals(role))) {
            resp.sendRedirect("access-denied.jsp");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                //deleteCustomer(req, resp);
                break;
            case "search":
                searchCustomer(req, resp);
                break;
            default:
                listCustomer(req, resp);
                break;
        }

    }

    private void searchCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        req.setAttribute("customerList", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/customers/list.jsp");
        dispatcher.forward(req, resp);
    }
}
