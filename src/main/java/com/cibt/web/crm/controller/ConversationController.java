/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.crm.controller;

import com.cibt.crm.web.repository.impl.ConversationRepositoryImpl;
import com.cibt.crm.web.service.ConversationService;
import com.cibt.crm.web.service.impl.ConversationServiceImpl;

/**
 *
 * @author dale
 */
public class ConversationController extends Controller{
    private ConversationService conversationService = new ConversationServiceImpl(new ConversationRepositoryImpl());
}
