/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public interface GenericDao<T,PK extends Serializable> {   
    public T findSensorById(PK id);
    public List<T> findSensorByDispositivo();
    public boolean save(T obj);
}
