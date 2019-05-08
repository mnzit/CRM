/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.service.impl;

import com.cibt.crm.web.entity.Customer;
import com.cibt.crm.web.repository.CustomerRepository;
import com.cibt.crm.web.service.CustomerService;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = null;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer fetchById(int id) throws Exception {
       return customerRepository.getById(id);
    }

    @Override
    public List<Customer> fetchAll() throws Exception {
        return customerRepository.getAll();
    }

}
