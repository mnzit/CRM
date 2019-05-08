/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.entity;

import java.util.Date;

/**
 *
 * @author dale
 */
public class Conversation {
    private int id;
    private Date messageDate;
    private Customer customerId;
    private String message;
    private int conversationTypeId;

    public Conversation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getConversationTypeId() {
        return conversationTypeId;
    }

    public void setConversationTypeId(int conversationTypeId) {
        this.conversationTypeId = conversationTypeId;
    }

    
    
}
