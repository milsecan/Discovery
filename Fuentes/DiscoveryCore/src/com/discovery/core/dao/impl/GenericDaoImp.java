/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.dao.impl;

import com.discovery.core.dao.GenericDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public abstract class GenericDaoImp<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Override
    public T findSensorById(PK id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findSensorByDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
