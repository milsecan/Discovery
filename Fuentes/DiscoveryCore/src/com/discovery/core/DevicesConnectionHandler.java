/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core;

/**
 *
 * @author USER
 */
public interface DevicesConnectionHandler { 
    public <T> void notifyConnection(T connection);
}
