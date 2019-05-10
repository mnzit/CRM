/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.web.repository;

import java.util.List;

/**
 *
 * @author Mnzit
 * @param <T>
 */
public interface CrudRepository<T> {

    void insert(T model) throws Exception;

    void update(T model) throws Exception;

    T getById(int id) throws Exception;

    List<T> getMultipleById(int id) throws Exception;

    void delete(int id) throws Exception;

    List<T> getAll() throws Exception;

}
