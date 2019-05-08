/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.service.impl;

import com.cibt.crm.web.entity.Conversation;
import com.cibt.crm.web.repository.ConversationRepository;
import com.cibt.crm.web.service.ConversationService;
import java.util.List;

/**
 *
 * @author dale
 */
public class ConversationServiceImpl implements  ConversationService{
    
     private ConversationRepository conversationRepository;

    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }
    @Override
    public void save(Conversation model) throws Exception {
        conversationRepository.insert(model);
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversation fetchById(int id) throws Exception {
        return conversationRepository.getById(id);
    }

    @Override
    public List<Conversation> fetchAll() throws Exception {
        return conversationRepository.getAll();
    }
    
}
