/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.repository.impl;

import com.cibt.crm.web.core.JdbcTemplate;
import com.cibt.crm.web.core.RowMapper;
import com.cibt.crm.web.entity.Customer;
import com.cibt.crm.web.repository.CustomerRepository;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    JdbcTemplate<Customer> template = new JdbcTemplate<>();

    @Override
    public void insert(Customer model) throws Exception {
        String sql = "INSERT into tbl_customer (name,email,contact_no) VALUES (?,?,?)";
        template.update(sql, new Object[]{model.getName(), model.getEmail(), model.getContactNo()});
    }

    @Override
    public void update(Customer model) throws Exception {
        String sql = "UPDATE tbl_customer set name=?,email=?,contact_no=?,date_modified=CURRENT_TIMESTAMP,status=? WHERE customer_id=?";
        template.update(sql, new Object[]{
            model.getName(),
            model.getEmail(),
            model.getContactNo(),
            model.getId()
        });
    }

    @Override
    public Customer getById(int id) throws Exception {
        String sql = "SELECT * from tbl_customer WHERE customer_id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }

    @Override
    public void delete(int id) throws Exception {
       String sql = "UPDATE tbl_customer SET deleted" ;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        String sql = "SELECT * from tbl_customer";
        return template.query(sql, null, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                return mapper(rs);
            }
        });
    }

    public Customer mapper(ResultSet rs) throws Exception {
        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setContactNo(rs.getString("contact_no"));
        customer.setStatus(rs.getBoolean("status"));
        return customer;
    }

}
