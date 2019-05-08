/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.web.repository.impl.CustomerRepositoryImpl;
import com.cibt.crm.web.service.CustomerService;
import com.cibt.crm.web.service.impl.CustomerServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "customer", urlPatterns = "/customer/*")
public class CustomerController extends Controller {

    private CustomerService customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().toLowerCase();
        try {
            if (uri.contains("profile")) {
                req.setAttribute("customer", customerService.fetchById(Integer.parseInt(req.getParameter("id"))));
                view("customer/profile", req, resp);
            } else if (uri.contains("delete")) {
                customerService.delete(Integer.parseInt(req.getParameter("id")));
                redirect("customer/index", req, resp);
            } else if (uri.contains("edit")) {
                req.setAttribute("customer", customerService.fetchById(Integer.parseInt(req.getParameter("id"))));
                view("customer/edit", req, resp);
            } else {
                req.setAttribute("customers", customerService.fetchAll());
                view("customer/index", req, resp);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view("customer", req, resp);
    }

}
