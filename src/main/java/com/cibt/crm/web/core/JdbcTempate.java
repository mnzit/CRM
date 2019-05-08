/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Mnzit
 */
public class JdbcTempate<T> {

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
    }

    public void addParameters(PreparedStatement pstm, Object[] args) throws Exception {
        int count = 1;
        for (Object arg : args) {
            pstm.setObject(count++, arg);
        }
    }

    public int query(String sql, Object[] args) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        addParameters(pstm, args);
        return pstm.executeUpdate();
    }
    
}
