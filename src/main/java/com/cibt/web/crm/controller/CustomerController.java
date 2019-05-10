/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.crm.controller;

import com.cibt.crm.web.repository.impl.ConversationRepositoryImpl;
import com.cibt.crm.web.repository.impl.CustomerRepositoryImpl;
import com.cibt.crm.web.repository.impl.MessageTypeRepositoryImpl;
import com.cibt.crm.web.service.ConversationService;
import com.cibt.crm.web.service.CustomerService;
import com.cibt.crm.web.service.MessageTypeService;
import com.cibt.crm.web.service.impl.ConversationServiceImpl;
import com.cibt.crm.web.service.impl.CustomerServiceImpl;
import com.cibt.crm.web.service.impl.MessageTypeServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "customer", urlPatterns = {"/customer/*"})
public class CustomerController extends Controller {

    private CustomerService customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
    private ConversationService conversationService = new ConversationServiceImpl(new ConversationRepositoryImpl());
    private MessageTypeService messageTypeService = new MessageTypeServiceImpl(new MessageTypeRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "customer/index";
        try {
            String uri = req.getRequestURI().toLowerCase();
            if (uri.contains("/profile")) {
                String[] tokens = uri.split("/");
                int id = Integer.parseInt(tokens[tokens.length - 1]);
                req.setAttribute("customer", customerService.fetchById(id));
                req.setAttribute("conversations", conversationService.fetchMultipleById(id));
                req.setAttribute("types",messageTypeService.fetchAll());
                forward = "customer/profile";
            } else if (uri.contains("/edit")) {
                String[] tokens = uri.split("/");
                int id = Integer.parseInt(tokens[tokens.length - 1]);
                req.setAttribute("customer", customerService.fetchById(id));
                forward = "customer/edit";
            } else if (uri.contains("/delete")) {
                String[] tokens = uri.split("/");
                int id = Integer.parseInt(tokens[tokens.length - 1]);
                customerService.delete(id);
                forward = "customer/delete";
            } else {
                req.setAttribute("customers", customerService.fetchAll());
            }
            view(forward, req, resp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            redirect(forward, req, resp);
        }
    }

}
