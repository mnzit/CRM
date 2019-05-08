/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.repository.impl;

import com.cibt.crm.web.core.JdbcTemplate;
import com.cibt.crm.web.core.RowMapper;
import com.cibt.crm.web.entity.Conversation;
import com.cibt.crm.web.entity.Customer;
import com.cibt.crm.web.entity.User;
import com.cibt.crm.web.repository.ConversationRepository;
import java.sql.ResultSet;
import java.util.Date;
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
        String sql = "insert into tbl_conversations (message,customerId) values(?,?)";

        template.update(sql, new Object[]{
            model.getMessage(),model.getCustomerId().getId()
        });

    }

    @Override
    public void update(Conversation model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversation getById(int id) throws Exception {
        String sql = "select * from tbl_conversation where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Conversation>() {
            @Override
            public Conversation mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conversation> getAll() throws Exception {
        String sql = "SELECT * from tbl_conversation";
        return template.query(sql, null, new RowMapper<Conversation>() {
            @Override
            public Conversation mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }
    
    public Conversation mapper(ResultSet rs) throws Exception {
        Conversation conversation = new Conversation();
          conversation.setId(rs.getInt("id"));
          conversation.setMessageDate(new Date(rs.getDate("message_date").getTime()));
          conversation.setMessage(rs.getString("message"));
        return conversation;
    }
    
}
