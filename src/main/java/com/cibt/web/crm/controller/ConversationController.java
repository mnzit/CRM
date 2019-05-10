/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.crm.controller;

import com.cibt.crm.web.entity.Conversation;
import com.cibt.crm.web.entity.Customer;
import com.cibt.crm.web.entity.MessageType;
import com.cibt.crm.web.repository.impl.ConversationRepositoryImpl;
import com.cibt.crm.web.service.ConversationService;
import com.cibt.crm.web.service.impl.ConversationServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dale
 */
@WebServlet(name = "conversation", urlPatterns = "/addconversation")
public class ConversationController extends Controller {

    private ConversationService conversationService = new ConversationServiceImpl(new ConversationRepositoryImpl());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Conversation conversation = new Conversation();
        try {
            conversation.setMessage(req.getParameter("message"));
            MessageType messageType = new MessageType();
            messageType.setId(Integer.parseInt(req.getParameter("type")));
            conversation.setMessageType(messageType);
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(req.getParameter("type")));
            conversation.setCustomerId(customer);
            conversationService.save(conversation);
            redirect("customer/profile/" + customer.getId(), req, resp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
