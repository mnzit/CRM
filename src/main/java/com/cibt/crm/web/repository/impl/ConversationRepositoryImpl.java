/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.repository.impl;

import com.cibt.crm.web.core.JdbcTemplate;
import com.cibt.crm.web.entity.Conversation;
import com.cibt.crm.web.entity.User;
import com.cibt.crm.web.repository.ConversationRepository;
import java.util.List;

/**
 *
 * @author dale
 */
public class ConversationRepositoryImpl implements ConversationRepository {

//    @Override
//    public void insert(Conversation model) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    private JdbcTemplate<Conversation> template = new JdbcTemplate<>();

    @Override
    public void insert(Conversation model) throws Exception {
        String sql = "insert into tbl_conversations (email,password,status) values(?,?,?)";

        template.update(sql, new Object[]{
            model.getEmail(), model.getPassword(), model.isStatus()
        });

    }

    @Override
    public void update(Conversation model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversation getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conversation> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
