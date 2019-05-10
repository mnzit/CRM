/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.service;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface GenericService<T> {

    void save(T model) throws Exception;

    void delete(int id) throws Exception;

    T fetchById(int id) throws Exception;

    List<T> fetchAll() throws Exception;
    
    List<T> fetchMultipleById(int id) throws Exception;
}
