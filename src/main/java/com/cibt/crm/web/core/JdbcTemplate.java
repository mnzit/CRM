/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class JdbcTemplate<T> {

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
    }

    public void addParameters(PreparedStatement pstm, Object[] args) throws Exception {
        int count = 1;
        for (Object arg : args) {
            pstm.setObject(count++, arg);
        }
    }

    public int update(String sql, Object[] args) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        addParameters(pstm, args);
        return pstm.executeUpdate();
    }

    public List<T> query(String sql, Object[] args, RowMapper<T> mapper) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        if (args != null) {
            addParameters(pstm, args);
        }
        List<T> coll = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            coll.add(mapper.mapRow(rs));
        }
        return coll;
    }

    public T queryForObject(String sql, Object[] args, RowMapper<T> mapper) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        addParameters(pstm, args);
        T model = null;
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            model = mapper.mapRow(rs);
        }
        return model;
    }

}
