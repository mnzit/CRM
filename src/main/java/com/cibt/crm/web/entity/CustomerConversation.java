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
public class CustomerConversation {
     private Date createdDate,modifiedDate;
     private int conversationType;
     private CustomerConversation customerid;

    public CustomerConversation() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getConversationType() {
        return conversationType;
    }

    public void setConversationType(int conversationType) {
        this.conversationType = conversationType;
    }

    public CustomerConversation getCustomerid() {
        return customerid;
    }

    public void setCustomerid(CustomerConversation customerid) {
        this.customerid = customerid;
    }

}
