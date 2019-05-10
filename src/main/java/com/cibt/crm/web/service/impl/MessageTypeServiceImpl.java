/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.service.impl;

import com.cibt.crm.web.entity.MessageType;
import com.cibt.crm.web.repository.MessageTypeRepository;
import com.cibt.crm.web.service.MessageTypeService;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class MessageTypeServiceImpl implements MessageTypeService {

    private MessageTypeRepository messageTypeRepository = null;

    public MessageTypeServiceImpl(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    @Override
    public void save(MessageType model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageType fetchById(int id) throws Exception {
        return messageTypeRepository.getById(id);
    }

    @Override
    public List<MessageType> fetchAll() throws Exception {
        return messageTypeRepository.getAll();
    }

    @Override
    public List<MessageType> fetchMultipleById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
