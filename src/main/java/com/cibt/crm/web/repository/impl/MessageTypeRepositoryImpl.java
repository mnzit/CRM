/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.repository.impl;

import com.cibt.crm.web.core.JdbcTemplate;
import com.cibt.crm.web.core.RowMapper;
import com.cibt.crm.web.entity.MessageType;
import com.cibt.crm.web.repository.MessageTypeRepository;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class MessageTypeRepositoryImpl implements MessageTypeRepository {

    private JdbcTemplate<MessageType> template = new JdbcTemplate<>();

    @Override
    public void insert(MessageType model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MessageType model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageType getById(int id) throws Exception {
        String sql = "SELECT * from tbl_message_type WHERE id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<MessageType>() {
            @Override
            public MessageType mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }

    @Override
    public List<MessageType> getMultipleById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageType> getAll() throws Exception {
        String sql = "SELECT * from tbl_message_type";
        return template.query(sql, null, new RowMapper<MessageType>() {
            @Override
            public MessageType mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }

    public MessageType mapper(ResultSet rs) throws Exception {
        MessageType msgType = new MessageType();
        msgType.setId(rs.getInt("id"));
        msgType.setType(rs.getString("type"));
        msgType.setColor(rs.getString("color"));
        return msgType;
    }

}
